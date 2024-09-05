package com.vinay.aopdemo.aspect.pointcutdeclaration;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//
//@Aspect
@Component
public class PointCutDeclaration {

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n-----> Executing @Before advice on addAccount (Pointcut)");
    }

    @Before("forDaoPackage()")
    public void performAPIAnalysis(){
        System.out.println("\n-----> Performing API Analysis (Pointcut)");
    }
}
