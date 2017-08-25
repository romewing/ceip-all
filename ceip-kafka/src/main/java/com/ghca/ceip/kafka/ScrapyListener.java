package com.ghca.ceip.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ScrapyListener {

    @KafkaListener(topics = "scrapy_kafka_item")
    public void processMessage(String content) {
        System.out.println(content);
    }
}
