package com.yc.projects.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class TestAspect {
    @Pointcut("execution(* com.yc.projects.biz..*(..))")
    private void abc(){}

//    @After("abc()")
//    public void show(){
//        System.out.println("after...只要方法执行完即可，不管正常或异常");
//    }

    @Around("abc()")
    public Object show02(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("在原方法之前...");
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("执行的时间为:"+(end-start));
        return obj;
    }
}
