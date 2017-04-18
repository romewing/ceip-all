package com.ghca.ceip.web.security.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.fasterxml.jackson.annotation.*;
import com.ghca.ceip.web.security.util.TreeUtil;
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
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/4/11.
 */
@Entity
@EntityListeners({AuditingEntityListener.class})
public class User implements UserDetails {

    public User(){

    };

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
    @ManyToOne(fetch = FetchType.EAGER)
    private User createUser;  //创建该用户的用户

    private Boolean locked;

    private Boolean enabled;

    private Boolean expired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", inverseJoinColumns = @JoinColumn(name = "role_id"), joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Permission> set = new HashSet<>();
        for(Role role : roles) {
            set.addAll(role.getPermissions());
        }
        return set.stream().filter((permission -> permission.getParent()==null)).collect(Collectors.toList());
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
    public boolean isAccountNonExpired() {
        return !getExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !getExpired();
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

    public User getCreateUser() {
        return createUser;
    }

    public Boolean getLocked() {
        return locked;
    }

    public Boolean getExpired() {
        return expired;
    }

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

    @JsonValue
    public JSONObject jsonValue() {
        JSONObject object = new JSONObject(true);
        object.fluentPut("id", getId())
                .fluentPut("username", getUsername())
                .fluentPut("password", getPassword())
                .fluentPut("locked", getLocked())
                .fluentPut("enabled", isEnabled())
                .fluentPut("expired", getExpired());
        if(createUser==null){
            object.put("createUser", "");
        }
        else {
            object.put("createUser", createUser.getId());
        }
        object.fluentPut("createTime", getCreateTime())
                .fluentPut("updateTime", getUpdateTime())
                .fluentPut("roles", getRoles().stream().map(role -> role.getId()).collect(Collectors.toList()));
        return object;
    }

    @Override
    public String toString() {
        return jsonValue().toJSONString();
    }

    @JSONCreator
    public User(String username, String passord) {
        this.username = username;
        this.password = passord;
    }


}
