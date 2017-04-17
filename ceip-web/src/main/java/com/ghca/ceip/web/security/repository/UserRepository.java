package com.ghca.ceip.web.security.repository;

import com.ghca.ceip.web.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * Created by gh on 2017/4/12.
 */
public interface UserRepository extends JpaRepository<User, String>{

    User findByUsername(String id);
}
