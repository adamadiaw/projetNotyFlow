package com.notyflow.consumer_stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumerStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerStockApplication.class, args);
    }
}