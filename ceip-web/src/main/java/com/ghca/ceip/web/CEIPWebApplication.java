
package com.ghca.ceip.web;

import com.ghca.ceip.web.security.entity.User;
import com.ghca.ceip.web.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Administrator on 2017/3/18.
 */
@SpringBootApplication
public class CEIPWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPWebApplication.class);
    }



    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                System.out.println("AAAA");
                User user = userRepository.findByUsername(username);
                return user;
            }
        };
    }


    @Configuration
    @ConditionalOnMissingBean({ CEIPWebSecurityConfigurerAdapter.class })
    @ConditionalOnProperty(prefix = "security.basic", name = "enabled", matchIfMissing = true)
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    private class CEIPWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {



        @Autowired
        private UserDetailsService userDetailsService;

        private final SecurityProperties securityProperties;

        public CEIPWebSecurityConfigurerAdapter(SecurityProperties security) {
            this.securityProperties = security;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin()
                    .loginPage("/").loginProcessingUrl("/login").successForwardUrl("/index").failureForwardUrl("/")
                    .permitAll()
                    .and().authorizeRequests().antMatchers("/ace/assets/**").permitAll()
                    .anyRequest().authenticated().and().rememberMe();
            if (!securityProperties.isEnableCsrf()) {
                http.csrf().disable();
            }
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }
    }
}
