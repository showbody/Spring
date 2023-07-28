package spring_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Banana.class, FruitImportSelector.class})
public class AppConfig_02 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_02.class);
        String [] names = ac.getBeanDefinitionNames();
        for (String n:names){
            System.out.println(n);
        }
    }
}
