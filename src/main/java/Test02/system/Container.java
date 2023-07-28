package Test02.system;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class Container<T> {

    private List<T> objs = new ArrayList<T>();

    @Resource(name="bmiMeasure")
    private Measure measure;

    @Resource(name="bmiFilter")

    private MyFilter filter;
    private T max;
    private T min;
    private double avg;
    private double sum;


    public int size(){
        return objs.size();
    }
    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }

    public void add(T t){
        if (filter!=null){
            if (filter.doMyFilter(t)==false){
                return;
            }
        }
        objs.add(t);

        if (objs.size()==1){
            max = t;
            min = t;
        }else {
            double val = this.measure.doMeasure(t);
            double maxval = this.measure.doMeasure(max);
            double minval = this.measure.doMeasure(min);
            if (val>maxval){
                max = t;
            }
            if (val<minval){
                min = t;
            }
        }

        sum+=measure.doMeasure(t);
        avg = sum/objs.size();
    }


    public void cleanAll(){
        objs = null;
        measure = null;
        filter = null;
        max = null;
        min = null;
        avg = 0;
    }
}
