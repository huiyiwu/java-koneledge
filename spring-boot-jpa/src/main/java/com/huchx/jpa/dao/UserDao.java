package com.huchx.jpa.dao;

import com.huchx.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {

}
