package com.hrdemo.controler;

import com.hrdemo.modle.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by OTOT on 2019/5/18.
 */
@RestController
public class Cotrolert {
    @GetMapping("/user")
    public String getlist(Model model){
        User user=new User(1,"里卡个","男");
        User user1=new User(5,"按虚岁","女");
        User user2=new User(4,"安慰","男");
        List<User> userList=new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        model.addAttribute("user",userList);
        return "/list";
    }
}
