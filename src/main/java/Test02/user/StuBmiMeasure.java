package Test02.user;

import Test02.system.Measure;
import org.springframework.stereotype.Component;

//di
@Component("bmiMeasure")
public class StuBmiMeasure implements Measure {
    @Override
    public double doMeasure(Object obj) {

        if (obj==null){
            throw new RuntimeException();
        }
        if (!(obj instanceof Stu)){
            throw new RuntimeException();
        }
        Stu s = (Stu) obj;
        return s.getWeight()/(s.getHeight()*s.getHeight());
    }
}
