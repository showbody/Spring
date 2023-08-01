package com.yc.projects.aspects;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

//@Component
//@Aspect
//@Order(1000)
public class HiAspect implements Ordered {

    @Pointcut("execution(* com.yc.projects.biz..*(..))")
    private void abc(){}

    @Before("abc()")
    public void doAccessCheck(){
        System.out.println("hi HiAspect");
    }

    @Override
    public int getOrder() {
        return 1111;
    }
}