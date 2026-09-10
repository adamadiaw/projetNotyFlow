package com.notyflow.consumer_email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerEmailApplication.class, args);
    }
}