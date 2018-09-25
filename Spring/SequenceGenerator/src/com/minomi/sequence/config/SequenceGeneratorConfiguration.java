package com.minomi.sequence.config;

import com.minomi.sequence.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 22..
 */

@Configuration
public class SequenceGeneratorConfiguration {

    @Bean
    public SequenceGenerator sequenceGenerator() {
        SequenceGenerator sequenceGenerator = new SequenceGenerator();
        sequenceGenerator.setPrefix("30");
        sequenceGenerator.setSuffix("A");
        sequenceGenerator.setInitial(100000);
        return sequenceGenerator;
    }

}
