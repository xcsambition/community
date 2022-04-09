package com.zfx.community.utils;

import com.zfx.community.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author zfx
 * @date 2022/4/9 19:15
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }

    public User getUser() {
        return users.get();
    }

    public void clear() {
        users.remove();
    }
}
