package com.hrdemo.controler;

import com.hrdemo.modle.User;
import com.hrdemo.msg.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OTOT on 2019/5/18.
 */
@RestController
public class UserControler {
    @Autowired
    MongoTemplate template;
    @GetMapping("/")
    public String test(){
        return"<h1>hi！</h1>";
    }
    @RequestMapping("/add.do")
    public Msg add(Model model, User user, Msg msg){
        System.out.println("?");
        template.save(user);
        if (user==null){
            return Msg.fail();
        }
        return Msg.success();
    }
    @GetMapping("/getlist.do")
    public Map<String ,Object> getlist(){
        System.out.println("?");
        Map<String,Object> map=new HashMap<>();
        List<User> users=new ArrayList<>();
        users=template.findAll(User.class);
        map.put("nan",users);
        return map;
            }
}
