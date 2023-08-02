package com.yc.projects.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//
@Component
@Aspect
public class TestAspect {
    @Pointcut("execution(* com.yc.projects.biz..*(..))")
    private void abc(){}

    @AfterReturning(pointcut = "abc()",returning = "retVal")
    public void show(Object retVal){
        System.out.println("returning,被增强的方法的返回值的结果为："+retVal);
    }



//    @AfterReturning("abc()")
//    public void show(){
//        Random r = new Random();
//        int a = r.nextInt(10);
//        System.out.println(a);
//        if (a<5){
//            throw new RuntimeException("异常");
//        }
//            System.out.println("after...只要方法执行完即可，不管正常或异常");
//    }

//    @Around("abc()")
//    public Object show02(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("在原方法之前...");
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long end = System.currentTimeMillis();
//        System.out.println("执行的时间为:"+(end-start));
//        return obj;
//    }
}
