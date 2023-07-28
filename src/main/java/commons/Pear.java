package commons;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pear {
    public Pear() {
        System.out.println("Pear的构造方法.....");
    }

    @PostConstruct
    public void init(){
        System.out.println("Pear的init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Pear的destroy");
    }
}
