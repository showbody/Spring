package org.ycframework.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.annotation.YcComponentScan;
import org.ycframework.annotation.YcConfiguration;

import java.util.*;

public class YcAnnotationConfigApplicationContext implements YcApplicationContext{

    private Logger logger  = LoggerFactory.getLogger(YcAnnotationConfigApplicationContext.class);

    private Map<String, YcBeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String,Object> beanMap = new HashMap<>();

    private Properties pros;



    public  YcAnnotationConfigApplicationContext(Class...configClasses){
       pros= System.getProperties();
       List<String> toScanPackagePath = new ArrayList<>();
       for (Class cls:configClasses){
           if(cls.isAnnotationPresent(YcConfiguration.class)==false){
               continue;
           }
           if (cls.isAnnotationPresent(YcComponentScan.class)){
               YcComponentScan ycConponentScan = (YcComponentScan) cls.getAnnotation(YcComponentScan.class);
               String[] basePackages = ycConponentScan.basePackages();
               if (basePackages==null||basePackages.length<=0) {
                   basePackages = new String[1];
                   basePackages[0] = cls.getPackage().getName();
               }
                   logger.info(cls.getName()+"类上有@YcComponentScan注解，它要扫描的路径:"+basePackages[0]);
           }
//           parseBeanAnnotation()
       }

    }

    @Override
    public Object getBean(String beanid) {
        return null;
    }
}
