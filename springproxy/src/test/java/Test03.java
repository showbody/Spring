import com.yc.CglibProxy.CglibProxyTool;
import com.yc.CglibProxy.FindBizIpml;

public class Test03 {
    public static void main(String[] args) {
        CglibProxyTool jpt = new CglibProxyTool(new FindBizIpml());
        FindBizIpml fi = (FindBizIpml) jpt.createProxy();
        System.out.println(fi);
        fi.find();

    }
}
