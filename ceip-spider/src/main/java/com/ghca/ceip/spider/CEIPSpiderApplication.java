package com.ghca.ceip.spider;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ghca.ceip.spider.service.CoreService;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequestBuilder;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
public class CEIPSpiderApplication {

    public static void main(String[] args) {
        Settings settings = Settings.builder()
                .put("cluster.name", "elastic").build();
//        TransportClient client = null;
//        try {
//            client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.3.51"), 9300))
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.3.52"), 9300))
//                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.3.53"), 9300));
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        Map<String, Object> json = new HashMap<String, Object>();
//        json.put("user","kimchy");
//        json.put("postDate",new Date());
//        json.put("message","trying out Elasticsearch");
//        //GetResponse response = client.prepareGet("twitter", "tweet", "AVuO8BQAyde1vTbxqKTv").get();
//        DeleteResponse response = client.prepareDelete("twitter", "tweet", "AVuO8BQAyde1vTbxqKTv").get();
//        System.out.println(response);
        System.out.println(Long.MAX_VALUE);
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




