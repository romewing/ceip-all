package com.ghca.ceip.web.security.controller;

import com.ghca.ceip.web.security.entity.Permission;
import com.ghca.ceip.web.security.repository.PermissionReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/4/18.
 */
@Controller
@RequestMapping("/system/security")
public class Securitycontroller {

    @Autowired
    private PermissionReository permissionReository;


    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    @ResponseBody
    public Collection<? extends GrantedAuthority> list(Principal principal) {
        if(principal instanceof Permission) {
            List<? extends GrantedAuthority> collect = ((Authentication) principal).getAuthorities().stream().filter((authority) -> authority instanceof Permission && ((Permission) authority).getParent() == null).collect(Collectors.toList());
            return collect;
        }
        else if(principal instanceof UsernamePasswordAuthenticationToken) {
            return ((UsernamePasswordAuthenticationToken) principal).getAuthorities();
        }
        return Collections.emptyList();
    }

    @RequestMapping("/authority")
    public String test() {
        return "tables";
    }

    @RequestMapping("/role")
    public String test1() {
        return "profile";
    }
}
