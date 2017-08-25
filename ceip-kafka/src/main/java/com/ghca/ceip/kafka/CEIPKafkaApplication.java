package com.ghca.ceip.kafka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class CEIPKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CEIPKafkaApplication.class);
    }
}
