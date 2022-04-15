package com.zfx.community.dao;

import com.zfx.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zfx
 * @date 2022/4/2 16:11
 */
@Mapper
public interface DiscussPostMapper {
    /**
     * 通过userId查询帖子
     *
     * @param userId 全部查询不需要userId，默认0为查询所有帖子
     * @param offset 每一页起始行的行号
     * @param limit  每一页最多显示多少数据
     * @return List<DiscussPost>
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 查询帖子总数
     * 如果只有一个参数，并且在if里面使用就必须加别名
     *
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);
}
