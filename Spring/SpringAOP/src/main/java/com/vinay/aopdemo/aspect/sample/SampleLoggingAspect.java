package com.vinay.aopdemo.aspect.sample;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class SampleLoggingAspect {

    // this is where we add the advices

//    // @Before Advice ( For method present in any class )
//    @Before("execution(public void addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method in a specific class )
//    @Before("execution(public void com.vinay.aopdemo.dao.AccountDao.addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method starting with add using wildcard )
//    @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method starting any return type )
//    @Before("execution(* add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method having Account as parameter )
//    @Before("execution(* add*(com.vinay.aopdemo.Account))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method having Account as parameter and more parameters )
//    @Before("execution(* add*(com.vinay.aopdemo.Account, ..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }

//    // @Before Advice ( For method having any parameters )
//    @Before("execution(* add*(..))")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n-----> Executing @Before advice on addAccount");
//    }
    // @Before Advice ( For any class and any method having any no of parameters in the given package only )
    @Before("execution(* com.vinay.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n-----> Executing @Before advice on addAccount");
    }
}
