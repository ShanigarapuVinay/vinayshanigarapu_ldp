package com.vinay.aopdemo;

import com.vinay.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean(AccountDao.class);
        List<Account> accountList = null;
        try{
            boolean tripWire = false;
            accountList = accountDao.findAccounts(tripWire);
        }catch (Exception ex){
            System.out.println("Main Program.. Catch Exception " + ex);
        }
        System.out.println("Main Program.... After Throwing App");
        System.out.println(accountList);
        System.out.println();
        context.close();
    }
}
