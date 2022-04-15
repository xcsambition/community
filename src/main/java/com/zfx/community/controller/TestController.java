package com.zfx.community.controller;

import com.google.code.kaptcha.Producer;
import com.zfx.community.dao.AlphaDao;
import com.zfx.community.utils.CommunityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zfx
 * @date 2022/4/2
 */

@RequestMapping("/test")
@Controller
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private AlphaDao alphaDao;

    @Resource()
    private Producer kaptchaProducer;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(int id) {
        alphaDao.select();
        return "hello,SpringBoot!";
    }

    @RequestMapping(path = "/path", method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "邹发贤");
        mav.setViewName("/demo/path");
        return mav;
    }

    @RequestMapping("/demo")
    public String get(Model model) {
        model.addAttribute("school", "北京大学");
        return "/demo/path2";
    }

    /**
     * 响应json数据
     */

    @RequestMapping("/json")
    @ResponseBody
    public Map<String, Object> json() {
        Map<String, Object> map2 = new HashMap<>(16);
        map2.put("name", "zfx");
        map2.put("年龄", 23);
        return map2;
    }

    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response) {
        //创建cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        //设置生效的范围
        cookie.setPath("/community/test");
        //设置生效的时间，单位是秒
        cookie.setMaxAge(60 * 10);
        response.addCookie(cookie);
        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(@CookieValue("code") String code) {
        System.out.println(code);
        return "get Session :" + code;
    }

    @RequestMapping(path = "/session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session) {
        session.setAttribute("id", "zfx");
        session.setAttribute("password", "xcsambition");
        return "set session";
    }

    @RequestMapping(path = "/session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session) {

        String s = "id:" + session.getAttribute("id") + "password:" + session.getAttribute("password");
        return s;
    }

//    @RequestMapping(path = "/kaptcha",method = RequestMethod.GET)
//    public void getKaptcha(HttpServletResponse response, HttpSession session) {
//        //生成验证码
//        String text = kaptchaProducer.createText();
//        BufferedImage image = kaptchaProducer.createImage(text);
//
//        //验证码存入Session
//        session.setAttribute("kaptcha", text);
//
//        response.setContentType("image/png");
//        try {
//            OutputStream os = response.getOutputStream();
//            ImageIO.write(image, "png", os);
//        } catch (IOException e) {
////            e.printStackTrace();
//            logger.error("获取图片失败");
//        }
//
//    }

    @RequestMapping(path = "/ajax",method = RequestMethod.POST)
    @ResponseBody
    public String testAjax() {
        return CommunityUtil.getJSONString(0, "操作成功");
    }


}
