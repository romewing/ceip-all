

package com.ghca.ceop.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by gh on 2017/3/15.
 */

@SpringCloudApplication
@EnableConfigServer
@EnableEurekaServer
public class CEIPConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPConfigApplication.class);
    }
}
