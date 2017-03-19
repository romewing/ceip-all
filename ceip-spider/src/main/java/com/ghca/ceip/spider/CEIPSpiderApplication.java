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
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
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
    }


   /* @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setUsePool(true);
        return jedisConnectionFactory;
    }*/


    /*@Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return  stringRedisTemplate;
    }*/

    @Bean
    public Scheduler scheduler() {
       return new RedisScheduler("127.0.0.1"){
            @Override
            protected boolean shouldReserved(Request request) {
                /*if("http://www.sccin.com.cn/InvestmentInfo/ZhaoBiao/houxuanren.aspx".equals(request.getUrl())) {
                    return true;
                }
                return super.shouldReserved(request);*/
                return true;
            }
        };

       //return new QueueScheduler();
    }

}




