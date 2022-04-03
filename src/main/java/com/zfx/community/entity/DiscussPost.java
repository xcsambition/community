package com.zfx.community.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zfx
 * @date 2022/4/2 15:57
 */
@Data
public class DiscussPost {
    private int id;
    private int userId;
    private String title;
    private String content;
    /***
     * 0普通，1置顶
     */
    private int type;
    /**
     * 0正常，1精华，2拉黑
     */
    private int status;
    private Date createTime;
    /**
     * 评论数量
     */
    private int commentCount;
    /**
     * 帖子分数
     */
    private double score;
}
