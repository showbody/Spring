package spring_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Banana.class)
public class AppConfigTest05 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest05.class);
        String [] names = ac.getBeanDefinitionNames();
        for (String n:names){
            System.out.println(n);
        }
        Banana b = (Banana) ac.getBean("spring_05.Banana");
        System.out.println(b);

        Banana b2 = ac.getBean(Banana.class);
        System.out.println(b2);


    }
}
