package com.hrdemo.shiro;

import com.hrdemo.modle.User;
import com.hrdemo.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by OTOT on 2019/5/22.
 */
@Service
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger log=Logger.getLogger(ShiroRealm.class);
  private  UserService service;

  @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        //获取传过来的用户名
        String username= token1.getUsername();
        //通过名字寻找数据库
        Map<String,Object> userInfo=this.service.queryInfoByUsername(username);
        if (userInfo == null) {
            System.out.println(1);
            throw new UnknownAccountException("用户密码错误");
        }
        //获取用户名
        Object name=userInfo.get("username");
        //获取密码
        Object pas=userInfo.get("password");
        //通过ByteSource转换把用户名当盐
        ByteSource salt=ByteSource.Util.bytes(name);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name,pas, salt, this.getName());
            return info;
    }
}
