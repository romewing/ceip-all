package com.ghca.ceip.spider;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ghca.ceip.spider.service.CoreService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.scheduler.Scheduler;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //1
@EnableCircuitBreaker //2
@EnableZuulProxy
public class CEIPSpiderApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(CEIPSpiderApplication.class);
        SpiderFactory bean = run.getBean(SpiderFactory.class);
        bean.getSpider("").start();
    }


}




