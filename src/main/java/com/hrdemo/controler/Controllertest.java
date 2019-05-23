package com.hrdemo.controler;

import com.hrdemo.modle.User;
import com.hrdemo.msg.Msg;
import com.hrdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
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
    @GetMapping("/list")
    public String userlist(Model model) {
        List<User> userList = new ArrayList<>();
        model.addAttribute("user", userList);
        return "/list";
    }
    @GetMapping("/ad")
        public String ad (){
        return "/add";
        }
    @PostMapping("/add")
    @ResponseBody
    public Msg add(Model model,User user,Msg msg){
        System.out.println("?");
        template.save(user);
        if (user==null){
            return Msg.fail(msg);
        }
        return Msg.success(msg);
    }
    @PostMapping("/up")
    public String login(String username, String password, Model model, HttpSession session,@ModelAttribute User user){
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
            user = (User) subject.getPrincipal();
            System.out.println("!!!");
            model.addAttribute("user", user);
            return "/hou/index";
        }catch (Exception e){
            System.out.println("错误密码"+password);
        return "/hou/login";
        }
    }

}
