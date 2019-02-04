package me.minomi.ioc_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocStudyApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(IocStudyApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run();
    }

}

