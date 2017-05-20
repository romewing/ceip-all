package com.ghca.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * Created by gh on 2017/4/11.
 */
@SpringBootApplication
public class CEIPDataApplication {

    public static void main(String[] args) {
            ConfigurableApplicationContext run = SpringApplication.run(CEIPDataApplication.class);
        JmsMessagingTemplate jmsMessagingTemplate = run.getBean(JmsMessagingTemplate.class);
        jmsMessagingTemplate.convertAndSend("t1", "测试消息");

    }


}
