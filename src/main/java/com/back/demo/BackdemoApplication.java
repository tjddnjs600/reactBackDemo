package com.back.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackdemoApplication.class, args);
    }

}
