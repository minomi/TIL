package com.minomi.sequence;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2018. 9. 25..
 */

@Component
public class AuditCheckBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("In AuditCheckBeanPostProcessor.postProcessBeforeInitialization,"
                + "processing bean type: " + o.getClass());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
