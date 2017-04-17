package com.ghca.ceip.security.repository;

import com.ghca.ceip.security.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by gh on 2017/4/12.
 */
public interface PermissionReository extends JpaRepository<Permission, String>{


    List<Permission> findPermissionsByParentIsNull();
}
