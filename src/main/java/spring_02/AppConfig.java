package spring_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Apple a(){
        Apple apple = new Apple();
        apple.setId(1);
        return apple;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Apple a = (Apple) ac.getBean("a");
        System.out.println(a);
    }
}
