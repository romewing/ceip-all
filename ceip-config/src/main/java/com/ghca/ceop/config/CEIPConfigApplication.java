

package com.ghca.ceop.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by gh on 2017/3/15.
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CEIPConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPConfigApplication.class);
    }
}
