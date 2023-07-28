package spring_03;

import org.springframework.beans.factory.FactoryBean;

public class FruitFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Pear();
    }

    @Override
    public Class<?> getObjectType() {
        return Pear.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
