package com.ghca.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by gh on 2017/4/11.
 */
@SpringBootApplication
public class CEIPDataApplication {

    public static void main(String[] args) {
            ConfigurableApplicationContext run = SpringApplication.run(CEIPDataApplication.class);
        TestRepository bean = run.getBean(TestRepository.class);
        for(int i =0; i< Integer.MAX_VALUE; i++) {
            TestEntity entity = new TestEntity();
            entity.setValue("test"+i);
            bean.save(entity);
        }
        System.out.println("over");
    }
}
