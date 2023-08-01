package org.ycframework;

import com.yc.MyConfig;
import com.yc.service.UserBiz;
import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

public class Test02 {
    public static void main(String[] args) {
        YcApplicationContext ac = new YcAnnotationConfigApplicationContext(MyConfig.class);
        UserBiz ub = (UserBiz) ac.getBean("ub");
        ub.add("kz");
    }
}
