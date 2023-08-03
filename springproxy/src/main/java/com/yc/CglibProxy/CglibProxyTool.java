package com.yc.CglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTool implements MethodInterceptor {
    private Object target;
    public CglibProxyTool(Object target){
        this.target = target;
    }

    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        Object proxy = enhancer.create();
        return proxy;

    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().startsWith("find")){
            show();
        }
        Object returnValue = method.invoke(target, objects);
        return returnValue;
    }

    private void show() {
        System.out.println("dddd");
    }
}
