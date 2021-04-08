package com.huchx.mybatis.mapper;

import com.huchx.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where id = #{id}")
    UserEntity getUserById(@Param("id")Integer id);

    @Insert("insert into users(name,age) values(#{name},#{age})")
    int addUser(@Param("name") String name,@Param("age") Integer age);
}
