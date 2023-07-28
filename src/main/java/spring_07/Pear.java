package spring_07;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pear {
    @PostConstruct
    public void init(){
        System.out.println("Pear的init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pear的destroy");
    }
}
