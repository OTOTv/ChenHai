package com.hrdemo.controler.url;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by OTOT on 2019/5/19.
 */
@Controller
public class UrlController {
    @GetMapping("/config")public String config(){return "/hou/config";}
    @GetMapping("/rabc")public String rabc(){return "/hou/rabc";}
    @GetMapping("/datepicker")public String datepicker(){return "/hou/datepicker";}
    @GetMapping("/chartjs")public String chartjs(){return "/hou/chartjs";}
    //------------------------------------------------------------------------------------------------------
    @GetMapping("/index")public String index(){return "/index";}
    @GetMapping("/profile")public String lyear_pages_profile(){return"/hou/profile";}
    @GetMapping("/repwd")public String lyear_pages_edit_pwd(){return"/hou/repwd";}
    @GetMapping("/login")public String lyear_pages_login(){return"/login";}
    @GetMapping("/405")public String eer(){return "/405";}
    @GetMapping("/zhuche")public String zhuc(){return "/zhuche";}

}
