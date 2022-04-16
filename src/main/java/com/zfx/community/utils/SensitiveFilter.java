package com.zfx.community.utils;

import org.springframework.stereotype.Component;

/**
 * @author zfx
 * @date 2022/4/16 20:00
 */
@Component
public class SensitiveFilter {
    /**
     * 过滤敏感词
     * @param text 带过滤的文本
     * @return 过滤后的文本
     */
    public String filter(String text) {

        return text;
    }
}
