package com.ghca.ceip.web.controller.security;

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

/**
 * Created by Administrator on 2017/4/18.
 */
@Controller
@RequestMapping("/security")
public class Securitycontroller {

    @Autowired
    private PermissionReository permissionReository;


    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    @ResponseBody
    public Collection<? extends GrantedAuthority> list(Principal principal) {
        if(principal instanceof Authentication) {
            return  ((Authentication) principal).getAuthorities();
        }
        return Collections.emptyList();

    }
}
