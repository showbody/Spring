package spring_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigTest3 {

    @Bean
    public FruitFactoryBean ffb(){
        return new FruitFactoryBean();
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfigTest3.class);
        Object obj01 = ac.getBean("ffb");
        System.out.println(obj01.hashCode());

        Object obj02 = ac.getBean("&ffb");
        System.out.println(obj02);

        Object obj03 = ac.getBean("ffb");
        System.out.println(obj03.hashCode());

    }
}
