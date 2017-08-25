package com.ghca.data;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by gh on 2017/4/11.
 */
@Entity
@Data
public class TestEntity {


    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(strategy = "uuid2", name = "id")
    private String id;
    private String value;

    private List<String> list;

}
