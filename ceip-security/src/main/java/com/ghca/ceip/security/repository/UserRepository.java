package com.ghca.ceip.security.repository;

import com.ghca.ceip.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by gh on 2017/4/11.
 */
public interface UserRepository extends JpaRepository<User, String>{
}
