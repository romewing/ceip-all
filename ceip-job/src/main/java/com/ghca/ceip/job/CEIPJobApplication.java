package com.ghca.ceip.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Created by Administrator on 2017/3/17.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //1
@EnableCircuitBreaker //2
@EnableZuulProxy
@EnableScheduling
public class CEIPJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPJobApplication.class);
    }


    @Bean
    public SchedulerFactoryBean schedulerFactory(){
        return new SchedulerFactoryBean();
    }

}
