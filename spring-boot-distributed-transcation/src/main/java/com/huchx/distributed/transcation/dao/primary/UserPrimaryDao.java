package com.huchx.distributed.transcation.dao.primary;

import com.huchx.distributed.transcation.entity.primary.UserPrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrimaryDao extends JpaRepository<UserPrimaryEntity,Integer> {

}
