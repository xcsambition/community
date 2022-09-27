package com.zfx.community.event;


import com.alibaba.fastjson.JSONObject;
import com.zfx.community.entity.Event;
import com.zfx.community.entity.Message;
import com.zfx.community.service.MessageService;
import com.zfx.community.utils.CommunityConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class EventConsumer implements CommunityConstant {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumer.class);

    @Resource
    private MessageService messageService;

    @KafkaListener(topics = {TOPIC_COMMENT, TOPIC_LIKE, TOPIC_FOLLOW})
    public void handleCommentMessage(ConsumerRecord record) {
        if (record == null) {
            logger.error("消息内容为空");
            return;
        }

        Event event = JSONObject.parseObject(record.value().toString(), Event.class);
        if (event == null) {
            logger.error("消息格式错误");
            return;
        }
        Message message = new Message();
        message.setConversationId(event.getTopic());
        message.setFromId(SYSTEM_USER_ID);
        message.setToId(event.getEntityUserId());
        message.setCreateTime(new Date());

        Map<String, Object> content = new HashMap<>();
        content.put("userId", event.getUserId());
        content.put("entityType", event.getEntityType());
        content.put("entityId", event.getEntityId());
        if (!event.getData().isEmpty()) {
            event.getData().forEach((key, value) -> {
                content.put(key, value);
            });
        }

        message.setContent(JSONObject.toJSONString(content));
        messageService.addMessage(message);
    }


}
