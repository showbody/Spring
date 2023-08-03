package com.yc.biz;

import org.springframework.stereotype.Service;

@Service
public class AccountBizImpl  implements AccountBiz {

    @Override
    public void add(int id, String money) {
        System.out.println(id+"..."+money);
    }
}
