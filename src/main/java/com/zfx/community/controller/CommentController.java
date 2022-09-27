package com.zfx.community.controller;

import com.zfx.community.entity.Comment;
import com.zfx.community.entity.DiscussPost;
import com.zfx.community.entity.Event;
import com.zfx.community.event.EventProducer;
import com.zfx.community.service.CommentService;
import com.zfx.community.service.DiscussPostService;
import com.zfx.community.utils.CommunityConstant;
import com.zfx.community.utils.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author zfx
 * @date 2022/4/30 22:24
 */
@Controller
@RequestMapping("/comment")
public class CommentController implements CommunityConstant {

    @Autowired
    private CommentService commentService;

    @Autowired
    private HostHolder hostHolder;

    @Resource
    private EventProducer eventProducer;

    @Resource
    private DiscussPostService discussPostService;

    @RequestMapping(path = "/add/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment) {
        comment.setUserId(hostHolder.getUser().getId());
        comment.setCreateTime(new Date());
        comment.setStatus(0);
        commentService.addComment(comment);
        // 触发评论事件
        Event event = new Event().
                setTopic(TOPIC_COMMENT).
                setUserId(hostHolder.getUser().getId()).
                setEntityType(comment.getEntityType()).
                setEntityId(comment.getEntityId()).
                setData("postId", discussPostId);

        if (comment.getEntityType() == ENTITY_TYPE_POST) {
            DiscussPost target = discussPostService.findDiscussPostById(comment.getEntityId());
            event.setEntityUserId(target.getUserId());
        } else if (comment.getEntityType() == ENTITY_TYPE_COMMENT) {
            Comment target = commentService.findCommentById(comment.getEntityId());
            event.setEntityUserId(target.getUserId());
        }
        eventProducer.fireEvent(event);

        return "redirect:/discuss/detail/" + discussPostId;
    }

}
