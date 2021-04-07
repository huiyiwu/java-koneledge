package com.huchx.transcation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void  add(String name ,String age){
        String sql = "insert into users(name,age) values(?,?)";
        int update = jdbcTemplate.update(sql,name,age);
        System.out.println(update);
    }
}
