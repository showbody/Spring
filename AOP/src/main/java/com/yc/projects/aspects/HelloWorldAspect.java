package com.yc.projects.aspects;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(9999)
public class HelloWorldAspect {


    //切入表达式
    @Pointcut("execution(* com.yc.projects.biz..*(..))")
    private void abc(){}

    //下面的方法是一个要加入的增强功能的方法  它会被加到abc（）的注解指定的位置
    @Before("abc()")
    public void doAccessCheck(){
        System.out.println("hi HelloWorldAspect");
    }
}
