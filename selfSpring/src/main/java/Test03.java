import com.yc.MyConfig;
import org.ycframework.context.YcAnnotationConfigApplicationContext;
import org.ycframework.context.YcApplicationContext;

public class Test03 {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Test.class);
//        logger.error("error");
//        logger.warn("warn");
//        logger.info("info");
//        logger.debug("debug");
//        logger.trace("trace");

        YcApplicationContext ac = new YcAnnotationConfigApplicationContext(MyConfig.class);
//        UserBiz ub = (UserBiz) ac.getBean("userBizImpl");
//        ub.add("kz");
    }
}