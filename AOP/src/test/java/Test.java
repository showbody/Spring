import com.yc.projects.AppConfig;
import com.yc.projects.biz.Stu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Stu stu = (Stu) ac.getBean("stuImpl");
        stu.add("zd");

    }
}
