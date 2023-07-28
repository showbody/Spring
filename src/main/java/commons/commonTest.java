package commons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("commons")
public class commonTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(commonTest.class);
        ((AnnotationConfigApplicationContext)ac).close();


    }
}