package com.hrdemo.service.impservice;

import com.hrdemo.dao.UserDao;
import com.hrdemo.modle.User;
import com.hrdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by OTOT on 2019/5/22.
 */
@Service
public class UserImpService implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User login(String username) {
        return this.userDao.login(username);
    }
}
