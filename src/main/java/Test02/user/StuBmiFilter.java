package Test02.user;

import Test02.system.MyFilter;
import org.springframework.stereotype.Component;

//di
@Component("bmiFilter")
public class StuBmiFilter implements MyFilter {
    @Override
    public boolean doMyFilter(Object obj) {
        if (obj==null){
            return false;
        }
        if (!(obj instanceof Stu)){
            return false;
        }
        Stu s = (Stu) obj;
        if (s.getSname()==null ||"".equalsIgnoreCase(s.getSname())){
            return false;
        }
        if (s.getHeight()<1 ||s.getHeight()>3.1){
            return false;
        }
        if (s.getWeight()<40 ||s.getWeight()>250){
            return false;
        }
        return true;
    }
}
