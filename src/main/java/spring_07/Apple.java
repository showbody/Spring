package spring_07;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Apple implements InitializingBean, DisposableBean {
    public Apple() {
        System.out.println("构造方法....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet....");
    }
}
