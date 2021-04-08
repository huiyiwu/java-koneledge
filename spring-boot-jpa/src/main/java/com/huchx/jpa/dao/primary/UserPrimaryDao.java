package com.huchx.jpa.dao.primary;

import com.huchx.jpa.entity.UserEntity;
import com.huchx.jpa.entity.primary.UserPrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrimaryDao extends JpaRepository<UserPrimaryEntity,Integer> {

}
