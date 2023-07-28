package spring_06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring_06")
public class AppConfigTest06 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest06.class);
        String [] names = ac.getBeanDefinitionNames();
        for (String n:names){
            System.out.println(n);
        }
    }
}
