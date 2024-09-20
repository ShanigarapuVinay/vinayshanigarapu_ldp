package com.vinay.aopdemo.aspect.after;

import com.vinay.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterAdvice {

    @After("execution(* com.vinay.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("---> Executing @After (Finally) on Method: " + method);
    }

}
