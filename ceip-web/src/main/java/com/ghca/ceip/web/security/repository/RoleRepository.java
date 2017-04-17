package com.ghca.ceip.web.security.repository;

import com.ghca.ceip.web.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by gh on 2017/4/12.
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
