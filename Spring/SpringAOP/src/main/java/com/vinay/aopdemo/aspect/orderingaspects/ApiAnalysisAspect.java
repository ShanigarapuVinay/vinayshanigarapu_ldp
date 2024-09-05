package com.vinay.aopdemo.aspect.orderingaspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Aspect
//@Order(3)
@Component
public class ApiAnalysisAspect {
    @Before("com.vinay.aopdemo.aspect.orderingaspects.AopExpressions.forDaoPackageNoGetterSetter()")
    public void performAPIAnalysis(){
        System.out.println("---> Performing API Analysis");
    }
}
