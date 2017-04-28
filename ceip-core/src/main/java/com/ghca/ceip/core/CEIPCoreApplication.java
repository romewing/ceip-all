package com.ghca.ceip.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by gh on 2017/3/16.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class CEIPCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(CEIPCoreApplication.class);
        String property = run.getEnvironment().getProperty("spring.datasource.url");
        System.out.println(property);
    }
}
