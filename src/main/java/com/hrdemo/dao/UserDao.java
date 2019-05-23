package com.hrdemo.dao;

import com.hrdemo.modle.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by OTOT on 2019/5/22.
 */
@Mapper
public interface UserDao {
    User login(String username);
}
