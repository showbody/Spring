package com.yc.Jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class CustomInvocationHandler implements InvocationHandler {

    private Object target;

    public CustomInvocationHandler(Object target) {
        this.target = target;
    }

    //生成代理  对象的方法
    public Object createProxy(){
        //jdk中提供了Proxy，有一个方法专门用于根据接口生成代理类对象的方法
        Object proxy = Proxy.newProxyInstance(CustomInvocationHandler.class.getClassLoader(),
                target.getClass().getInterfaces(), this);
        return proxy;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method 调用的方法
     * @param args   方法的参数值
     * @return
     * @throws Throwable
     */
    //当在主程序中调用生成的Proxy的中的方法  会自动回调这个invoke()，在这个invoke加入增强  切面的功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       if (method.getName().startsWith("add")){
           showTime();
       }
       //反射机制调用目标类的目标方法
        Object returnValue = method.invoke(target, args);
        return returnValue;
    }


    //增强的方法
    private void showTime() {
        System.out.println("时间为:"+new Date());
    }
}
