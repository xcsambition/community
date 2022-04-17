package com.zfx.community;

import com.zfx.community.dao.DiscussPostMapper;
import com.zfx.community.dao.LoginTicketMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author zfx
 * @date 2022/4/8 17:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Resource
    LoginTicketMapper loginTicketMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void loginTicketTest() {

//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setUserId(101);
//        loginTicket.setTicket("abc");
//        loginTicket.setStatus(0);
//        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
//
//        loginTicketMapper.insertLoginTicket(loginTicket);

//        LoginTicket get = loginTicketMapper.selectByTicket("abc");
//        System.out.println(get);
//        int i = loginTicketMapper.updateStatus("abc", 0);
//        System.out.println(i);

//        LoginTicket loginTicket = new LoginTicket();
//        loginTicket.setUserId(10000);
//        loginTicket.setTicket("test");
//        loginTicket.setStatus(0);
//        long l = System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365;
//        System.out.println(new Date());
//        long l = System.currentTimeMillis();
//        System.out.println(l);
//        System.out.println(new Date(Long.MAX_VALUE));
//        System.out.println(new Date(0));
//        System.out.println(new Date(1000 * 3600 * 24 ));
//        System.out.println(new Date((long)1000 * 3600 * 24 *50));

//        System.out.println(l);
//        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 3600 * 12 * 100));
//        loginTicketMapper.insertLoginTicket(loginTicket);
        loginTicketMapper.updateStatus("f508df09f8674681b084c4cc004d295b", 1);

    }

//    @Test
//    public void testInsertDiscuss() {
//        DiscussPost discussPost = new DiscussPost();
//        discussPost.setUserId(281);
//        discussPost.setTitle("test");
//        discussPost.setContent("test content");
//        discussPost.setCreateTime(new Date());
//        int i = discussPostMapper.insertDiscussPost(discussPost);
//        System.out.println(i);
//
//    }


}
