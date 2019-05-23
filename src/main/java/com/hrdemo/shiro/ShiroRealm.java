package com.hrdemo.shiro;

import com.hrdemo.modle.User;
import com.hrdemo.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //log.error("");
        UsernamePasswordToken token1= (UsernamePasswordToken) token;
        String username= token1.getUsername();
        String password=new String((char [])token.getCredentials());
        User user = this.service.login(username);
        if (user == null) {
            throw new UnknownAccountException("用户密码错误");
        }
            if (!password.equals(user.getPassword())) {
                throw new IncorrectCredentialsException("aassa");
            }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,password,getName());

        return info;
    }
}
