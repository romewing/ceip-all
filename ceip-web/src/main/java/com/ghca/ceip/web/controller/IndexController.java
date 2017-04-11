package com.ghca.ceip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/22.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping("/role")
    public String role() {
        return "views/system/role";
    }
}

