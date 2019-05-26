package com.hrdemo.service;

import com.hrdemo.modle.User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by OTOT on 2019/5/22.
 */
@Service
public interface UserService {

    /**
     * @param username
     * @return
     * 登录
     */
    User login(String username);

    /**
     * @param username
     * @param password
     * @return
     * 注册
     */
    boolean insertU(String username,String password,User user);
    Map<String,Object>queryInfoByUsername(String username);
}
