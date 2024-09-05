package com.vinay.aopdemo.aspect.orderingaspects;

import com.vinay.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//
//@Aspect
//@Order(2)
@Component
public class LoggingAspect {
    @Before("com.vinay.aopdemo.aspect.orderingaspects.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeMethods(JoinPoint joinPoint){
        System.out.println("---> Performing Logging");
        // get method signature
        Signature methodSig = (Signature) joinPoint.getSignature();
        System.out.println("Method Signature : " + methodSig);

        // get method args
        Object[] args = joinPoint.getArgs();

        for(Object arg : args)
            System.out.println(arg);
    }
}
