package com.vinay.aopdemo;

import com.vinay.aopdemo.dao.AccountDao;
import com.vinay.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class AroundDemoApp {
    private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService trafficFortuneService = context.getBean(TrafficFortuneService.class);

        myLogger.info("Main Progress - AroundDemoApp");
        myLogger.info("Calling getFortune Method");
        String fortune = trafficFortuneService.getFortune();
        myLogger.info("My Fortune is " + fortune);
        myLogger.info("Done..");
        context.close();
    }
}
