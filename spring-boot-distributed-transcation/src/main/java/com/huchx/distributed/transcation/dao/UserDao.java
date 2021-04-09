package com.huchx.distributed.transcation.dao;


import com.huchx.distributed.transcation.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {

}
