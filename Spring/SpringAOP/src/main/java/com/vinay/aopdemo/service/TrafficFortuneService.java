package com.vinay.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expecting heavy traffic in this area..";
    }

    public String getFortune(boolean tripWire) {
        if(tripWire)
            throw new RuntimeException("Ohh hoo you are soo unlucky The road is closed..");
        return getFortune();
    }
}
