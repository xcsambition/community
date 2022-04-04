package com.zfx.community.controller;

import com.zfx.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zfx
 * @date 2022/4/2
 */

@RequestMapping("/test")
@Controller
public class HelloController {
    @Autowired
    private AlphaDao alphaDao;

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
}
