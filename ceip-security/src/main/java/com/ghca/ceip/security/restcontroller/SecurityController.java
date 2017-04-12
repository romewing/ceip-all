package com.ghca.ceip.security.restcontroller;

import com.ghca.ceip.security.entity.Permission;
import com.ghca.ceip.security.entity.Role;
import com.ghca.ceip.security.entity.User;
import com.ghca.ceip.security.repository.PermissionReository;
import com.ghca.ceip.security.repository.RoleRepository;
import com.ghca.ceip.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh on 2017/4/11.
 */

@RestController
@RequestMapping("/security")
public class SecurityController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionReository permissionReository;


    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return (User) userRepository.findByUsername(username);
    }

    @PostMapping("/role")
    public void createRole(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @PostMapping("/permission")
    public void createPermission(@RequestBody Permission permission) {
        permissionReository.save(permission);
    }

    @GetMapping("/permission")
    public List<Permission> listPermission() {
        return new ArrayList<>();
    }







}
