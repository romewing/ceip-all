package com.ghca.ceip.security.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/11.
 */
@Entity
@EntityListeners({AuditingEntityListener.class})
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String username;
    private String password;


    @CreatedDate
    private Date createTime;  //用户创建时间

    @LastModifiedDate
    private Date updateTime;  //密码修改时间

    @CreatedBy
    @ManyToOne
    private User createUser;  //创建该用户的用户

    private Boolean locked;

    private Boolean enabled;

    private Boolean expired;

    @ManyToMany
    @JoinTable(name = "user_role", inverseJoinColumns = @JoinColumn(name = "role_id"), joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return getExpired();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return getExpired();
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public String getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public User getCreateUser() {
        return createUser;
    }

    public Boolean getLocked() {
        return locked;
    }

    public Boolean getExpired() {
        return expired;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    //@JsonValue
    public String toString() {
        JSONObject object = new JSONObject();
        object.fluentPut("username", getUsername())
                .fluentPut("password", getPassword())
                .fluentPut("id", getId());
        return object.toJSONString();
    }
}
