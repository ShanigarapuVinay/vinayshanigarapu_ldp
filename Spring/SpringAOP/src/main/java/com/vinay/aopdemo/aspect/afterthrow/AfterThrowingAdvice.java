package com.vinay.aopdemo.aspect.afterthrow;

import com.vinay.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterThrowingAdvice {

    @AfterThrowing(
            pointcut = "execution(* com.vinay.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "theExe")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExe) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("---> Executing @AfterThrowing on Method: " + method);

        System.out.println("---> Exception: " + theExe);
    }
}
