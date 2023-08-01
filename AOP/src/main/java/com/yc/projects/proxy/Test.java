package com.yc.projects.proxy;

import com.yc.projects.biz.Stu;
import com.yc.projects.biz.StuImpl;

public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Stu target = new StuImpl();//目标类
        CustomInvocationHandler handler = new CustomInvocationHandler(target);

        //生成的代理类
        Object proxy = handler.createProxy();
        System.out.println(proxy);

        Stu s = (Stu) proxy;
        s.add("zzz");
    }
}
