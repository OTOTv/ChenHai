package com.hrdemo.controler;

import com.hrdemo.modle.User;
import com.hrdemo.msg.Msg;
import com.hrdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OTOT on 2019/5/18.
 */
@Controller
@RequestMapping("/user")
public class Controllertest {
    @Autowired
    MongoTemplate template;
    @Autowired
    UserService userService;

    /**
     * @param username
     * @param password
     * @return
     * 登录接口
     */
    @PostMapping("/up")
    public String login(String username, String password){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return "redirect:/index";
        }catch (Exception e){
            System.out.println("错误密码"+password);
        }
        return "redirect:/login";
    }

    /**
     * @param session
     * @return
     * 退出登录接口
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        Subject subject=SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
        }
        return "redirect:/login";
    }

    /**
     * @param username
     * @param password
     * @param user
     * @return
     * 注册接口
     */
    @RequestMapping("/zhuc")
    public String zhuc(String username, String password,User user){
        boolean b=userService.insertU(username,password,user);
        if (b){
            return "redirect:/login";
        }
        return "redirect:/zhuche";
    }
}
