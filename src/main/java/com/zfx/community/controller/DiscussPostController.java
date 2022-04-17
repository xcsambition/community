package com.zfx.community.controller;

import com.zfx.community.entity.DiscussPost;
import com.zfx.community.entity.User;
import com.zfx.community.service.DiscussPostService;
import com.zfx.community.service.UserService;
import com.zfx.community.utils.CommunityUtil;
import com.zfx.community.utils.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author zfx
 * @date 2022/4/16 20:09
 */
@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;


    @RequestMapping("/add")
    @ResponseBody
    public String addDiscussPost(String title,String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "你还没有登录!");
        }

        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(user.getId());
        discussPost.setContent(content);
        discussPost.setTitle(title);
        discussPost.setCreateTime(new Date());
        discussPostService.addDiscussPost(discussPost);

        //报错的情况，将来统一处理
        return CommunityUtil.getJSONString(0, "发布成功！");


    }

    @RequestMapping(path = "/detail/{discussPostId}",method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId")int discussPostId, Model model) {
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post",post);
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user",user);

        return "/site/discuss-detail";
    }
}
