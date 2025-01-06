package com.vinay.webapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TodoLoggingAspect {
    private Logger myLogger = Logger.getLogger(TodoLoggingAspect.class.getName());

    @Pointcut("execution(* com.vinay.webapp.controller.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* com.vinay.webapp.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut("execution(* com.vinay.webapp.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        myLogger.info("----> @Before Advice Calling Method: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for(Object arg : args)
            myLogger.info("----> Argument: " + arg);
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        myLogger.info("----> @AfterReturning Advice for Method: " + joinPoint.getSignature().toShortString());

        myLogger.info("----> Result: " + result);
    }
}
