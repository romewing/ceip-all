package com.ghca.ceip.web.security.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.*;
import com.ghca.ceip.web.security.util.TreeNode;
import netscape.javascript.JSObject;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by gh on 2017/4/12.
 */

@Entity
@EntityListeners(AuditListener.class)
public class Permission implements TreeNode<Permission>, GrantedAuthority {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private Boolean menu;

    private String url;

    @ManyToOne
    private User createUser;

    private Date createTime;

    @ManyToOne
    @JoinColumn
    private Permission parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
    private Collection<Permission> children = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public Permission getParent() {
        return parent;
    }

    @Override
    public Collection<Permission> getChildren() {
        return children;
    }

    @Override
    public void setChildren(Collection<Permission> children) {

    }

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public void setParent(Permission parent) {

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Permission) {
            return ((Permission) obj).getId().equals(getId());
        }
        return false;
    }

    @JsonValue
    public JSONObject jsonValue() {
        JSONObject object = new JSONObject();
        object.put("id", getId());
        object.put("name", getName());
        Permission parent = getParent();
        object.put("pId", parent==null?"":parent.getId());
        return object;
    }

    @Override
    public String toString() {
        return jsonValue().toJSONString();
    }
}
