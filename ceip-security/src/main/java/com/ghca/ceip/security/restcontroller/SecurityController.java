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

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

    @GetMapping(value = {"/user", "/user/{id}"})
    public List<User> listUser(@PathVariable(required = false) String id) {
       /* if(StringUtils.isNotBlank(id)) {
            User user = userRepository.findByUsername(id);
            List<User> list = new ArrayList<>();
            list.add(user);
            return list;
        }
        else {
            return userRepository.findAll();
        }*/
       return null;
    }

    @PostMapping("/role")
    public void createRole(@RequestBody Role role) {
        roleRepository.save(role);
    }

    @PostMapping("/permission")
    public void createPermission(@RequestBody Permission permission) {
        permissionReository.save(permission);
    }

    @GetMapping("/permission/*")
    public List<Permission> listPermission(@PathVariable String id) {
        return new ArrayList<>();
    }








}
