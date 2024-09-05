package com.vinay.aopdemo;

import com.vinay.aopdemo.dao.AccountDao;
import com.vinay.aopdemo.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean(AccountDao.class);
        MembershipDao membershipDao = context.getBean(MembershipDao.class);

        Account account = new Account();
        account.setName("Vinay");
        account.setLevel("Platinum");
        System.out.println("AccountDao Dao");
        accountDao.addAccount();
        accountDao.addAccountWithParameters(account, true);
        accountDao.update();

        System.out.println();

        System.out.println("Membership Dao");
        membershipDao.addAccount();
        membershipDao.addDiscount();
        membershipDao.update();


        System.out.println("PointCut Combo");
        accountDao.setName("Vinay");
        accountDao.setServiceCode("123456");

        accountDao.getName();
        accountDao.getServiceCode();
        context.close();
    }
}
