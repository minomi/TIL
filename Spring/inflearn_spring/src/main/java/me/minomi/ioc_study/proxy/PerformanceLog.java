package me.minomi.ioc_study.proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PerformanceLog {
}
