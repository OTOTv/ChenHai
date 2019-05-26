package com.hrdemo.service.impservice;

import com.hrdemo.dao.UserDao;
import com.hrdemo.modle.User;
import com.hrdemo.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    @Override
    public boolean insertU(String username, String password,User user) {
       // User user=new User();
        user=this.userDao.login(username);
       if (user==null){
           //转换成盐
            ByteSource salt=ByteSource.Util.bytes(username);
            //把密码转成MD5，
            String pass=new SimpleHash("MD5",password,salt,1).toHex();
            this.userDao.insertU(username,pass);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> queryInfoByUsername(String username) {
        return this.userDao.queryInfoByUsername(username);
    }
}
