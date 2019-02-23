package me.minomi.jpaandbatchstudy.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */
@EnableBatchProcessing
@Configuration
public class JobConfig {
    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
}
