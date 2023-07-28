package Test01;

import org.springframework.stereotype.Repository;

@Repository          //@Repository标识这是一个dao层的类 由spring托管
                     //@Component
public class UserDaoImpl implements UserDao {

    public UserDaoImpl (){
        System.out.println("UserDaoImpl的构造方法...");
    }

    @Override
    public void add(String uname) {
        System.out.println("添加了:"+uname);
    }
}
