package com.vinay.aopdemo.aspect.afterreturn;

import com.vinay.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AfterReturnAdvice {

//    @AfterReturning(
//            pointcut = "execution(* com.vinay.aopdemo.dao.AccountDao.findAccounts(..))",
//            returning = "result")
//    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
//        String method = joinPoint.getSignature().toShortString();
//        System.out.println("---> Executing @AfterReturning on Method: " + method);
//        System.out.println("---> Result: " + result);
//    }

    // Modify the Result
    @AfterReturning(
            pointcut = "execution(* com.vinay.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("---> Executing @AfterReturning on Method: " + method);
        System.out.println("---> Result: " + result);

        // post process data
        // convert the names to uppercase
        convertAccountNamesToUppercase(result);
        System.out.println("---> Modified Result: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for(Account account : result)
            account.setName(account.getName().toUpperCase());
    }
}
