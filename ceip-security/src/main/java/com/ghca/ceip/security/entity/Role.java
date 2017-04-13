package com.ghca.ceip.security.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Administrator on 2017/4/11.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Role implements GrantedAuthority {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;

    @CreatedBy
    @ManyToOne
    private User createUser;

    @CreatedDate
    private Date createTime;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "role_permission", inverseJoinColumns = @JoinColumn(name = "permission_id"), joinColumns = @JoinColumn(name = "role_id"))
    private Set<Permission> permissions = new HashSet<>();

    @Override
    @JsonIgnore
    public String getAuthority() {
        return name;
    }


    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public Set<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public User getCreateUser() {
        return createUser;
    }
}
