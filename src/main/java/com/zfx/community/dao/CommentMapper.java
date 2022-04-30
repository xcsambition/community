package com.zfx.community.dao;

import com.zfx.community.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zfx
 * @date 2022/4/23 14:50
 */
@Mapper
public interface CommentMapper {

    /**
     * @param entityType 评论目标类型
     * @param entityId   评论目标id
     * @param offset     分页起始
     * @param limit      分页每页数目
     * @return
     */
    List<Comment> selectCommentByEntity(int entityType, int entityId, int offset, int limit);


    /**
     * @param entityType 评论目标类型
     * @param entityId   评论目标id
     * @return 该类型的评论总数
     */
    int selectCountByEntity(int entityType, int entityId);

}
