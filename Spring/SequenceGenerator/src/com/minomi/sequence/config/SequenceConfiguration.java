package com.minomi.sequence.config;

import com.minomi.sequence.DatePrefixGenerator;
import com.minomi.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */

@Configuration
public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator datePrefixGenerator = new DatePrefixGenerator();
        datePrefixGenerator.setPattern("yyyyMMdd");
        return datePrefixGenerator;
    }

    @Bean
    @DependsOn("datePrefixGenerator")
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setInitial(100000);
        sequenceGenerator.setSuffix("A");
        return sequenceGenerator;
    }
}
