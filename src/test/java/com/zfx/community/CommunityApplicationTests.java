package com.zfx.community;


import com.zfx.community.dao.AlphaDao;
import com.zfx.community.dao.DiscussPostMapper;
import com.zfx.community.entity.DiscussPost;
import com.zfx.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests
//        implements ApplicationContextAware
{
//    @Resource
    @Resource
    private ApplicationContext applicationContext;

    @Resource
//    @Qualifier("AlphaHibernate")
    private AlphaDao AlphaHibernate2;
//   @Override
//   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//       this.applicationContext = applicationContext;
//   }
    @Test
    public void contextLoads() {
        System.out.println(applicationContext);
        AlphaDao contextDao = applicationContext.getBean("AlphaHibernate",AlphaDao.class);
//        System.out.println(alphaDao);
        System.out.println(contextDao);
//        System.out.println(contextDao == alphaDao);

    }

    @Test
    public void testBeanManagement(){
        System.out.println("获取实例前");
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println("获取实例后");
        System.out.println(alphaService);

    }
    @Resource
    private SimpleDateFormat simpleDateFormat;
    @Test
    public void testBeanConfig(){
//        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
//        System.out.println(applicationContext.getBean(AlphaConfiguration.class).simpleDateFormat() == simpleDateFormat);
        System.out.println(simpleDateFormat.format(new Date()));
//        System.out.println(alphaDao);
    }

    @Test
    public void test(){
//        System.out.println(AlphaHibernate2);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
//        char c = '2';
//        int a = (int)c;
//        System.out.println(a);
    }

    @Autowired
    DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts(){
        List<DiscussPost> postList = discussPostMapper.selectDiscussPosts(149, 0, 10);
        postList.forEach(System.out::println);
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger("name");
        logger.debug("debug");
        logger.debug(logger.getClass().toString());
        logger.info("info");
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
        logger.warn("warn");

    }



}
