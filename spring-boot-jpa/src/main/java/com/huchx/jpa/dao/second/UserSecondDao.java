package com.huchx.jpa.dao.second;

import com.huchx.jpa.entity.UserEntity;
import com.huchx.jpa.entity.second.UserSecondEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSecondDao extends JpaRepository<UserSecondEntity,Integer> {

}
