package com.yc;

import com.yc.bean.Account;
import com.yc.config.AppConfig;
import com.yc.config.DataSourceConfig;
import com.yc.dao.AccountDao;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ AppConfig.class, DataSourceConfig.class})
@Log4j2
public class AccountDaoJdbcTemplateImplTest extends TestCase {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void update(){
        accountDao.update(1,100);
    }

    @Test
    public void delete(){
        accountDao.delete(2);
    }

    @Test
    public void insert(){
        int accountid = accountDao.insert(100);
        log.info("新增的用户为："+accountid);
        Assert.assertNotNull(accountid);
    }
    @Test
    public void findById(){
        Account account = this.accountDao.findById(1);
        log.info(account);
    }
    @Test
    public void findCount(){
        int total = accountDao.findCount();
        Assert.assertEquals(2,total);
    }

    @Test
    public void findAll(){
        List<Account> list = this.accountDao.findAll();
        log.info(list);
    }

}
