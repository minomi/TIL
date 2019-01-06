package me.minomi.async_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class AsyncTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncTestApplication.class, args);
    }

}

