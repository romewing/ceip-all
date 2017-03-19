package com.ghca.ceip.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/3/18.
 */
@Entity
public class Leader {
    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(strategy = "uuid2", name = "id")
    private String id;

    private String name;  //名字

    private String title;  //职务

    private String number; //证书编号

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
