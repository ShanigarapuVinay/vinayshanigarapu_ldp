package com.vinay.aopdemo.dao;

import com.vinay.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDao {
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + " in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " in setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " in setServiceCode");
        this.serviceCode = serviceCode;
    }

    public void addAccount() {
        System.out.println(getClass() + " adding this account");
    }
    public void addAccountWithParameters(Account account, boolean vipEntry) {
        System.out.println(getClass() + " adding this account");
    }

    public void update(){
        System.out.println(getClass() + " update the AccountDao");
    }

    // For After Return Advise Practice
    public List<Account> findAccounts(boolean tripWire){
        if(tripWire){
            throw new RuntimeException("Ohh Noo you tripped and fell straight to hell!!");
        }
        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account("Virat", "Platinum");
        Account account2 = new Account("Rohit", "Platinum");
        Account account3 = new Account("Vinay", "Gold");

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;
    }
}