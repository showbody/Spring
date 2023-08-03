package com.yc;

import com.yc.bean.OpRecord;
import com.yc.bean.OpType;
import com.yc.config.AppConfig;
import com.yc.config.DataSourceConfig;
import com.yc.dao.OpRecordDao;
import junit.framework.TestCase;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DataSourceConfig.class})
@Log4j2
public class OpRecordJdbcTemplateImplTest extends TestCase {
    @Autowired
    private OpRecordDao opRecordDao;

    @Test
    public void insertOpRecord(){
        OpRecord opRecord = new OpRecord();
        opRecord.setAccountid(1);
        opRecord.setOpmoney(5);
        opRecord.setOpType(OpType.DEPOSITE);
        this.opRecordDao.insertOpRecord(opRecord);
    }

    @Test
    public  void findOpRecord(){
        List<OpRecord> list = this.opRecordDao.findOpRecord(1);
        System.out.println(list);
    }


    @Test
    public  void testFindOpRecord(){
        List<OpRecord> list = this.opRecordDao.findOpRecord(2,"DEPOSITE");
        System.out.println(list);
    }

    @Test
    public  void testFindOpRecord1(){

    }

}
