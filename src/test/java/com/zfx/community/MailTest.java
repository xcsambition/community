package com.zfx.community;

import com.zfx.community.utils.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author zfx
 * @date 2022/4/4 00:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
//        String to = "1633697855@qq.com";
        String to = "xcsambition@sina.com";
        mailClient.sendMail(to, "demo_text", "主要内容demo");
    }

    @Test
    public void testHtmlMail() {
        String to = "1633697855@qq.com";
        Context context = new Context();
        context.setVariable("username", "BumBleBee");
        String content = templateEngine.process("/mail/demo", context);
        mailClient.sendMail(to, "demo_Html", content);

    }





}
