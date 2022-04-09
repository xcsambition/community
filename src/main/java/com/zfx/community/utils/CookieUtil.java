package com.zfx.community.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zfx
 * @date 2022/4/9 18:58
 */
public class CookieUtil {
    /**
     * 根据名字从请求中找到想要的cookie
     * @param request
     * @param name
     * @return
     */
    public static String getValue(HttpServletRequest request, String name) {
        if (request==null || name == null) {
            throw new IllegalArgumentException("参数为空！");
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;

    }
}
