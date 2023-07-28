package commons;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommonHandler implements BeanPostProcessor {

    @Override
     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
         System.out.println("CommonHandler的postProcessBeforeInitialization");
         return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CommonHandler的postProcessAfterInitialization");
        return bean;
    }
}
