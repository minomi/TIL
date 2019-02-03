package me.minomi.ioc_study.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-03.
 */

@Component
public class MessageSourceAppRunner implements ApplicationRunner {

    @Autowired
    MessageSource messageSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String koGreeting = messageSource.getMessage("greeting", new String[]{"minho"}, Locale.KOREA);
        String usGreeting = messageSource.getMessage("greeting", new String[]{"minho"}, Locale.US);
        System.out.println(koGreeting);
        System.out.println(usGreeting);
    }
}
