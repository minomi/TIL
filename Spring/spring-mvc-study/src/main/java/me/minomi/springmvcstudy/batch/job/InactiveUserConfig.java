package me.minomi.springmvcstudy.batch.job;

import me.minomi.springmvcstudy.batch.User;
import me.minomi.springmvcstudy.batch.UserRepository;
import me.minomi.springmvcstudy.batch.UserStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-19.
 */

@Configuration
public class InactiveUserConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public Job inactiveUserJob(JobBuilderFactory jobBuilderFactory, Step inactiveJobStep) {
        return jobBuilderFactory.get("inactiveJob")
                .start(inactiveJobStep)
                .build();
    }

    @Bean
    public Step inactiveJobStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("inactiveJobStep")
                .<User, User>chunk(10)
                .reader(inactiveJobReader())
                .processor(inactiveJobProcessor())
                .writer(inactiveJobWriter())
                .build();
    }

    @Bean
    @StepScope
    public QueueItemReader<User> inactiveJobReader() {
        List<User> oldUsers = userRepository.findByUpdatedDateBeforeAndStatusEquals(LocalDateTime.now().minusYears(1), UserStatus.ACTIVE);
        return new QueueItemReader<>(oldUsers);
    }

    @Bean
    @StepScope
    public ItemProcessor<User, User> inactiveJobProcessor() {
        return User::changeInactive;
    }

    @Bean
    @StepScope
    public ItemWriter<User> inactiveJobWriter() {
        return (List<? extends User> users) -> userRepository.saveAll(users);
    }




}
