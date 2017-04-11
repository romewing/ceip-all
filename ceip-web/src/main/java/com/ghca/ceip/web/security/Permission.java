package com.ghca.ceip.web.security;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;

/**
 * Created by gh on 2017/4/11.
 */
@Entity
public class Permission implements GrantedAuthority{
    @Override
    public String getAuthority() {
        return null;
    }
}
