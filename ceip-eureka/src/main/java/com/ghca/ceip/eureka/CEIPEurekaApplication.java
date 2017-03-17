package com.ghca.ceip.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by gh on 2017/3/15.
 */
@SpringBootApplication
@EnableEurekaServer
public class CEIPEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CEIPEurekaApplication.class);
    }
}
