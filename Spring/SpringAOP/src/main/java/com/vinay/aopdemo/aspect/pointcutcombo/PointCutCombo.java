package com.vinay.aopdemo.aspect.pointcutcombo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class PointCutCombo {

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.*(..))")
    public void forPackageDao() {}

    @Pointcut("forPackageDao() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

//    @Before("getter()")
//    public void beforeGetters(){
//        System.out.println("----> Advice before getter method");
//    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeMethods(){
        System.out.println("----> Advice before any method other than getters and setters");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performAPIAnalysis(){
        System.out.println("\n-----> Performing API Analysis");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("\n-----> Logging to Cloud");
    }
}
