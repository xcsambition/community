package com.zfx.community.service;

import com.zfx.community.dao.UserMapper;
import com.zfx.community.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zfx
 * @date 2022/4/2 17:49
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User findUserById(int id){
        return userMapper.selectById(id);

    }

}
