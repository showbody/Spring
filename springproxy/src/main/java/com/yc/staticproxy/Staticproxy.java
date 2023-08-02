package com.yc.staticproxy;

public class Staticproxy implements OrderBiz {
  private OrderBiz orderBiz;

    public Staticproxy(OrderBiz orderBiz) {
        this.orderBiz = orderBiz;
    }


    @Override
    public void add() {
        before();
        this.orderBiz.add();
        after();
    }

    private void after() {
        System.out.println("before...");
    }

    private void before() {
        System.out.println("after...");
    }
}
