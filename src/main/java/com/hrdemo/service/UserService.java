package com.hrdemo.service;

import com.hrdemo.modle.User;
import org.springframework.stereotype.Service;

/**
 * Created by OTOT on 2019/5/22.
 */
@Service
public interface UserService {
    User login(String username);
}
