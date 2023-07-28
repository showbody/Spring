package Test02;


import Test02.system.Container;
import Test02.user.Stu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig_Test02.class);
        Container c = (Container) ac.getBean("container");
        c.add(new Stu("a",1.7,100.5));
        c.add(new Stu("b",0.2,120.5));
        c.add(new Stu("c",3.5,200.0));
        c.add(new Stu("d",0.1,200.5));

        System.out.println(c.getMax());
        System.out.println(c.getMin());
        System.out.println(c.getAvg());
        System.out.println(c.size());
        String [] names = ac.getBeanDefinitionNames();
        for (String n:names){
            System.out.println(n);
        }
    }
}
