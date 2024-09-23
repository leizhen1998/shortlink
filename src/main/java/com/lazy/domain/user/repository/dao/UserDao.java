package com.lazy.domain.user.repository.dao;

import com.lazy.domain.user.repository.po.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserPO, Long> {
}
