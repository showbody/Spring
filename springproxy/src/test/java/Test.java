import com.yc.staticproxy.OrderBiz;
import com.yc.staticproxy.OrderBizImpl;
import com.yc.staticproxy.Staticproxy;

public class Test {
    public static void main(String[] args) {
        OrderBiz ob = new Staticproxy(new OrderBizImpl());
        ob.add();
    }
}
