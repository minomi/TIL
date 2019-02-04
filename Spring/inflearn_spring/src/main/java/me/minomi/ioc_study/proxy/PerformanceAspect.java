package me.minomi.ioc_study.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-04.
 */

@Component
@Aspect
public class PerformanceAspect {

    @Around("@annotation(PerformanceLog)") // PerformanceLog 어노테이션이 달린 메서드 전 후에 실행하라
    public Object logPerformance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object returnObj = proceedingJoinPoint.proceed();
        long performanceTime = System.currentTimeMillis() - start;

        String name = proceedingJoinPoint.getSignature().getName();
        System.out.println(name + " 수행시간 : " + performanceTime);
        return returnObj;
    }
}
