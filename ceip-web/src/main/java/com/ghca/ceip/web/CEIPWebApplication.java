
package com.ghca.ceip.web;

import com.ghca.ceip.web.security.entity.User;
import com.ghca.ceip.web.security.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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

    @Bean
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public WebSecurityConfigurerAdapter webSecurityConfigurer() {
        return new WebSecurityConfigurerAdapter() {

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.formLogin()
                        .loginPage("/").loginProcessingUrl("/login").successForwardUrl("/index").failureForwardUrl("/")
                        .permitAll()
                        .and().authorizeRequests().antMatchers("/ace/assets/**").permitAll()
                        .anyRequest().authenticated()
                        .and().headers().contentTypeOptions().disable()
                       // .and().csrf().csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                ;
            }
        };
    }
}
