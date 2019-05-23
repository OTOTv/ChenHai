package com.hrdemo.controler.url;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by OTOT on 2019/5/19.
 */
@Controller
public class UrlController {
    @GetMapping("/index")public String index(){return "/hou/index";}
    @GetMapping("/lyear_ui_buttons")public String an(){return"/hou/lyear_ui_buttons";}
    @GetMapping("/lyear_ui_cards")public String lyear_ui_cards(){return"/hou/lyear_ui_cards";}
    @GetMapping("/lyear_ui_grid")public String lyear_ui_grid(){return"/hou/lyear_ui_grid";}
    @GetMapping("/lyear_ui_icons")public String lyear_ui_icons(){return"/hou/lyear_ui_icons";}
    @GetMapping("/lyear_ui_tables")public String lyear_ui_tables(){return"/hou/lyear_ui_tables";}
    @GetMapping("/lyear_ui_modals")public String lyear_ui_modals(){return"/hou/lyear_ui_modals";}
    @GetMapping("/lyear_ui_tooltips_popover")public String lyear_ui_tooltips_popover(){return"/hou/lyear_ui_tooltips_popover";}
    @GetMapping("/lyear_ui_alerts")public String lyear_ui_alerts(){return"/hou/lyear_ui_alerts";}
    @GetMapping("/lyear_ui_pagination")public String lyear_ui_pagination(){return"/hou/lyear_ui_pagination";}
    @GetMapping("/lyear_ui_progress")public String lyear_ui_progress(){return"/hou/lyear_ui_progress";}
    @GetMapping("/lyear_ui_tabs")public String lyear_ui_tabs(){return"/hou/lyear_ui_tabs";}
    @GetMapping("/lyear_ui_typography")public String lyear_ui_typography(){return"/hou/lyear_ui_typography";}
    @GetMapping("/lyear_ui_step")public String lyear_ui_step(){return"/hou/lyear_ui_step";}
    @GetMapping("/lyear_ui_other")public String lyear_ui_other(){return"/hou/lyear_ui_other";}
    //----------------------------------------------------------------------------
    @GetMapping("/lyear_pages_profile")public String lyear_pages_profile(){return"/hou/lyear_pages_profile";}
    @GetMapping("/lyear_pages_edit_pwd")public String lyear_pages_edit_pwd(){return"/hou/lyear_pages_edit_pwd";}
    @GetMapping("/login")public String lyear_pages_login(){return"/hou/login";}
    @GetMapping("/405")public String eer(){return "/405";}

}
