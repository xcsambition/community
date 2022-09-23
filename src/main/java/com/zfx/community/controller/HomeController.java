package com.zfx.community.controller;

import com.zfx.community.entity.DiscussPost;
import com.zfx.community.entity.Page;
import com.zfx.community.entity.User;
import com.zfx.community.service.DiscussPostService;
import com.zfx.community.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zfx
 * @date 2022/4/2 18:04
 */
@Controller
public class HomeController {
    @Resource
    private DiscussPostService discussPostService;
    @Resource
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String get() {
        return "redirect:/index";
    }


    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (!list.isEmpty()) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";


    }

    @RequestMapping(path = "error", method = RequestMethod.GET)
    public String getErrorPage() {
        return "/error/500";
    }


}
