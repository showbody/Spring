import com.yc.Jdkproxy.CustomInvocationHandler;
import com.yc.Jdkproxy.AddBiz;
import com.yc.Jdkproxy.AddBizImpl;


public class Test02 {
    public static void main(String[] args) {
        //全局属性配置
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        AddBiz target = new AddBizImpl();//目标类
        CustomInvocationHandler handler = new CustomInvocationHandler(target);

        //生成的代理类
        Object proxy = handler.createProxy();
        System.out.println(proxy);

        AddBiz s = (AddBiz) proxy;
        s.add("aa");


    }
}
