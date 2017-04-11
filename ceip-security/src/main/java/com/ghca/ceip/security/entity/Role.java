package com.ghca.ceip.security.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by gh on 2017/4/10.
 */
public class Role implements GrantedAuthority {

    private String id;

    private String name;


    @Override
    public String getAuthority() {
        return name;
    }
}
