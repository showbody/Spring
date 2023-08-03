package com.yc;

import com.yc.biz.AccountBiz;
import com.yc.config.AppConfig;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Log4j2
public class Test1 extends TestCase {

    @Autowired
    private AccountBiz accountBiz;

    @Test
    public void test(){
        log.info("dddd");
        accountBiz.add(1,"100");
    }

    @Test
    public void test01(){
        int x=1,y=2;
        Assert.assertEquals(3,x+y);
    }

}
