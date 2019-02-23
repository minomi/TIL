package me.minomi.jpaandbatchstudy.batch.job;

import me.minomi.jpaandbatchstudy.accounts.Account;
import me.minomi.jpaandbatchstudy.accounts.AccountRepository;
import me.minomi.jpaandbatchstudy.accounts.Status;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-20.
 */

@Configuration
public class InactiveAccountJobConfig {

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public Job inactiveUserJob(JobBuilderFactory jobBuilderFactory, Step inactiveJobStep) {
        return jobBuilderFactory.get("inactiveJob")
                .start(inactiveJobStep)
                .build();
    }

    @Bean
    public Step inactiveJobStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("inactiveJobStep")
                .<Account, Account>chunk(10)
                .reader(inactiveJobReader())
                .processor(inactiveJobProcessor())
                .writer(inactiveJobWriter())
                .build();
    }

    @Bean
    @StepScope
    public ListItemReader<Account> inactiveJobReader() {
        List<Account> oldUsers = accountRepository.findByUpdatedDateBeforeAndStatusEquals(LocalDateTime.now().minusYears(1), Status.ACTIVE);
        return new ListItemReader<>(oldUsers);
    }

    public ItemProcessor<Account, Account> inactiveJobProcessor() {
        return Account::changeInactive;
    }

    public ItemWriter<Account> inactiveJobWriter() {
        return (List<? extends Account> users) -> accountRepository.saveAll(users);
    }

}
