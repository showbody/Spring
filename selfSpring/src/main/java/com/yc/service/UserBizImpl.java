package com.yc.service;

import com.yc.dao.UserDao;
import org.ycframework.annotation.YcResource;
import org.ycframework.annotation.YcService;

@YcService(value = "ub")
//@YcScope
//@YcLazy
public class UserBizImpl implements UserBiz {

    @YcResource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}
