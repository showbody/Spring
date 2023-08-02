package com.yc.projects.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class GetJoinitPointInfo {
    @Pointcut("execution(* com.yc.projects.biz..*(..))")
    private void abc(){}

    @Before("abc()")//如何获取联接点信息
    private  void showInfo(JoinPoint jp){
        System.out.println("联接点的信息如下:");
        System.out.println("目标类:"+jp.getTarget()+",方法的签名:"+jp.getSignature());
        System.out.print("加了增强的方法中的参数值:");

        Object[] objects = jp.getArgs();
        if (objects!=null&objects.length>0){
            for (Object o:objects){
                System.out.println(o);

            }
        }
    }
}
