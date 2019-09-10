package me.minho.annotation;

import java.lang.annotation.*;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-09-01.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface MyAnnotation {
    String name() default "minho";
    int age() default 29;
}
