package spring_05;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class FruitNameImportBeanfinitions implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean bean = beanDefinitionRegistry.containsBeanDefinition("spring_03.Pear");
        if (bean){
            RootBeanDefinition d = new RootBeanDefinition(Grape.class);
            beanDefinitionRegistry.registerBeanDefinition("grape",d);
        }
    }

}
