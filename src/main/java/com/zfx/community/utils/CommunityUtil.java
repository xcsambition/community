package com.zfx.community.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zfx
 * @date 2022/4/5 02:57
 */
public class CommunityUtil {

    /**
     * 生成随机字符串
     *
     * @return 字母 不要横线 数字
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * MD5加密
     */
    public static String md5(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     *
     * @param code 状态码 0为正常
     * @param msg 状态信息
     * @param map 主要信息
     * @return json字符串
     */
    public static String getJSONString(int code, String msg, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        if (map != null) {
            //lambda
//           map.forEach((key, value) -> {
//               json.put(key, value);
//           });
            //迭代器
//            Set<Map.Entry<String, Object>> entries = map.entrySet();
//            for (Map.Entry<String, Object> entry : entries) {
//                json.put(entry.getKey(), entry.getValue());
//            }
            for (String key : map.keySet()) {
                json.put(key, map.get(key));
            }

//            json.putAll(map);
        }
        return json.toJSONString();
    }

    public static String getJSONString(int code, String msg) {
        return getJSONString(code, msg, null);
    }

    public static String getJSONString(int code) {
        return getJSONString(code, null, null);
    }

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name", "zfx");
        map.put("age", 19);
        System.out.println(getJSONString(0, "ok", map));

    }

}
