package com.vinay.aopdemo.dao;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public void addAccount(){
        System.out.println(getClass() + " adding a Membership Account");
    }

    public boolean addDiscount(){
        System.out.println(getClass() + " adding a Membership discount");
        return true;
    }

    public void update(){
        System.out.println(getClass() + " update the Membership account");
    }
}
