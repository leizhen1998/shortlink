package com.lazy.domain.user.repository.persistence;

import com.lazy.domain.user.repository.dao.UserDao;
import com.lazy.domain.user.repository.facade.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean existsById(Long id) {
        return userDao.existsById(id);
    }
}
