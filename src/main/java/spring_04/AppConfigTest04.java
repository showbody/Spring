package spring_04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring_04")
public class AppConfigTest04 {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest04.class);
       ProductBiz pb = (ProductBiz) ac.getBean("productedBizImpl");
       pb.takein();
    }
}
