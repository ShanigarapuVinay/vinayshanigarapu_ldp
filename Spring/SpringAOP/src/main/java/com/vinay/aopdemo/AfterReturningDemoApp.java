package com.vinay.aopdemo;

import com.vinay.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean(AccountDao.class);

        List<Account> accountList = accountDao.findAccounts(false);
        System.out.println("Main Program....");
        System.out.println(accountList);
        System.out.println();
        context.close();
    }
}
