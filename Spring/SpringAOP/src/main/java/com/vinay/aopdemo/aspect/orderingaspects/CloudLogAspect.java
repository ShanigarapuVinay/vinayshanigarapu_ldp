package com.vinay.aopdemo.aspect.orderingaspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//
//@Aspect
//@Order(1)
@Component
public class CloudLogAspect {
    @Before("com.vinay.aopdemo.aspect.orderingaspects.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("---> Logging to Cloud");
    }
}
