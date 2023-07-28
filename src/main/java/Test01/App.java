package Test01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class App {
    @Autowired
    private UserBizImpl userBiz;

    @Autowired
    private  UserDaoImpl userDao;


    @Test
    public void test01(){
        userDao.add("fvv");
        System.out.println(userBiz);
        System.out.println(userDao);
    }
}
