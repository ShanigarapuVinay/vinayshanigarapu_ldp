package com.vinay.aopdemo.aspect.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AroundHandleExceptionAdvice {
    private Logger myLogger = Logger.getLogger(AroundHandleExceptionAdvice.class.getName());

    @Around("execution(* com.vinay.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        myLogger.info("---> Executing @Around on Method: " + method);

        // begin timestamp
        Long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception ex){
            myLogger.warning(ex.getMessage());
            // Swallow / handle -> result = "Omg the Road is closed but we can find one more route!!";
            throw ex;
        }

        // end timestamp
        Long end = System.currentTimeMillis();

        Long duration = end - begin;
        myLogger.info("---> Time taken to execute the method is " + duration/1000.0 + " seconds");

        return result;
    }
}
