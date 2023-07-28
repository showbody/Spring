package Test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);


        UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
        ub.add("zs");
        System.out.println();
    }
}
