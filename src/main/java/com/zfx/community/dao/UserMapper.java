package com.zfx.community.dao;

import com.zfx.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zfx
 * @date 2022/4/2 17:49
 */
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
