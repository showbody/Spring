package Test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    public UserBizImpl() {
        System.out.println("UserBizImpl的构造方法....");
    }

    @Override
    public void add(String uname) {
        System.out.println("添加了："+uname);

    }
}
