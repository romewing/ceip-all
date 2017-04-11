package com.ghca.ceip.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * Created by gh on 2017/4/11.
 */

@SpringBootApplication
public class CEIPSecurityApplication {

    public static void main(String[] args) {

    }


    @Bean
    public  UserDetailsManager userDetailsManager() {
        return new JdbcUserDetailsManager();
    }

}
