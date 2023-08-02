package com.yc.projects.biz;

import org.springframework.stereotype.Component;

@Component
public class StuImpl implements Stu {
    @Override
    public void  add(String name){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("add..."+name);
    }
}
