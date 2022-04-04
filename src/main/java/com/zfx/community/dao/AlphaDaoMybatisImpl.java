package com.zfx.community.dao;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("AlphaMybatis")
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "mybatis";
    }
}
