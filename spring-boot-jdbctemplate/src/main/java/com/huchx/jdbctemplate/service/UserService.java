package com.huchx.jdbctemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void  addUser(){
        String sql = "insert into users values(null,?,?)";
        System.out.println("新增用户");
        jdbcTemplate.update(sql,"huchx",27);
    }
}
