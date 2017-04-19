package com.ghca.ceip.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Administrator on 2017/3/22.
 */

@Controller
public class IndexController {

    /*
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/blank")
    public String form(){
        return "layouts/blank";
    }*/

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index(Principal principal) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return "blank";
    }

}

