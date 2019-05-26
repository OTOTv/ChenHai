package com.hrdemo.dao;

import com.hrdemo.modle.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Map;

/**
 * Created by OTOT on 2019/5/22.
 */
@Mapper
public interface UserDao {
    /**
     * @param username
     * ？测试
     * @return
     */
    User login(String username);

    /**
     * @param username
     * @param password
     * @return
     * 注册用户
     */
    boolean insertU(@Param("username") String username, @Param("password") String password);//多参数要加@Param

    /**
     * @param username
     * @return
     * 通过用户名匹配数据库信息
     */
    public Map<String, Object> queryInfoByUsername(String username);
}
