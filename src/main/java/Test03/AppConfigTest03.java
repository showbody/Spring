package Test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.concurrent.ExecutorService;

public class AppConfigTest03 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        ExecutorService executorService = (ExecutorService) ac.getBean("th");
        for (int i=0;i<5;i++){
            executorService.submit(()->{
                while (true){
                    Date d = new Date();
                    System.out.println(Thread.currentThread().getName()+"时间为:"+d);
                    Thread.sleep(1000);
                }
            });
        }
    }
}
