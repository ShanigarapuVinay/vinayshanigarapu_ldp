package com.vinay.aopdemo.aspect.orderingaspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.vinay.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.vinay.aopdemo.dao.*.*(..))")
    public void forPackageDao() {}

    @Pointcut("forPackageDao() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
