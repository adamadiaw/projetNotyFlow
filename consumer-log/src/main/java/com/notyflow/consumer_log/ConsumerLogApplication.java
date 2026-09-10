package com.notyflow.consumer_log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerLogApplication.class, args);
    }
}