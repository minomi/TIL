package me.minomi.spring_data_jpa_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaStudyApplication.class, args);
    }

}
