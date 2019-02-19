package me.minomi.springmvcstudy;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringMvcStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcStudyApplication.class, args);
    }

}

