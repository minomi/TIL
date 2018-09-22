package com.minomi.sequence;

import com.minomi.sequence.config.SequenceGeneratorConfiguration;
import com.minomi.sequence.dao.SequenceDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 23..
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.minomi.sequence");
        SequenceDao sequenceDao = context.getBean(SequenceDao.class);
        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
    }
}
