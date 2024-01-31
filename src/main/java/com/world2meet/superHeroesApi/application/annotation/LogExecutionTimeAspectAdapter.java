package com.world2meet.superHeroesApi.application.annotation;

import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspectAdapter {


    @Around("@annotation(com.world2meet.superHeroesApi.domain.utils.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        Logger.getLogger("LogExecutionTimeAspectAdapter").info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        // TODO: add colors and improve the log message
        return proceed;
    }
}