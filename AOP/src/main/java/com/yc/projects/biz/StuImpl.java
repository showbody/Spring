package com.yc.projects.biz;

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
