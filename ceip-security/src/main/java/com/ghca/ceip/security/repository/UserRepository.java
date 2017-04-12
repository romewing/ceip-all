package com.ghca.ceip.security.repository;

import com.ghca.ceip.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * Created by gh on 2017/4/12.
 */
public interface UserRepository extends JpaRepository<User, String>, UserDetailsManager{

    //User findByUsername(String username);
}
