package org.ycframework.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ycframework.annotation.*;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class YcAnnotationConfigApplicationContext implements YcApplicationContext{

    private Logger logger  = LoggerFactory.getLogger(YcAnnotationConfigApplicationContext.class);
    //存每个待托管的Bean的定义信息
    private Map<String, YcBeanDefinition> beanDefinitionMap = new HashMap<>();
    //存每个实例化后的Bean
    private Map<String,Object> beanMap = new HashMap<>();
    //存系统属性 db.properties
    private Properties pros;



    public  YcAnnotationConfigApplicationContext(Class...configClasses){
       try {
       //读取系统的属性 存好
       pros= System.getProperties();
       List<String> toScanPackagePath = new ArrayList<>();
       for (Class cls:configClasses){
           if(cls.isAnnotationPresent(YcConfiguration.class)==false){
               continue;
           }
           String[] basePackages = null;
           //扫描配置类上的@YcComponentScan注解 读取要扫描的包
//           logger.info("cls为:"+cls);
           if (cls.isAnnotationPresent(YcComponentScan.class)){
               //此配置上有@YcComponentScan注解 读取要扫描的包
               YcComponentScan ycConponentScan = (YcComponentScan) cls.getAnnotation(YcComponentScan.class);
               basePackages = ycConponentScan.basePackages();
               if (basePackages==null||basePackages.length<=0) {
                   basePackages = new String[1];
                   basePackages[0] = cls.getPackage().getName();
               }
                   logger.info(cls.getName()+"类上有@YcComponentScan注解，它要扫描的路径:"+basePackages[0]);
           }
           //开始扫描这些basePackages包下的bean 并加载包装成YcBeanDefinition对象  存到beanDinifitionMap
           recursiveLoadBeanDefinition(basePackages);
       }
       //循环beanDefinitionMap，创建bean(是否为懒加载，是单例)  存到beanMap
           createBean();
       //循环所有托管的beanMap中的bean，看属性和方法上是否有@Autowired,@Resource,@Value  考虑di
            doDi();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
    //开始扫描这些basePackages包下的bean 并加载包装成YcBeanDefinition对象  存到beanDinifitionMap
    private void doDi() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //循环的是beanMap 这是托管bean
        for (Map.Entry<String,Object> entry:beanMap.entrySet()){
            String beanId = entry.getKey();
            Object beanObj = entry.getValue();
            //有三种情况
            //1.属性上有@YcResource注解的情况
            //2.方法上有@YcResource注解的情况
            //3.构造方法上有@YcResource注解的情况  下面是第一种情况
            Field[] fields = beanObj.getClass().getDeclaredFields();
            for (Field field:fields){
                if (field.isAnnotationPresent(YcResource.class)){
                    YcResource ycResource = field.getAnnotation(YcResource.class);
                    String toDiBeanId = ycResource.name();
                    //从beanMap 中找  是否singleton 是否lazy
                    Object obj = getToDiBean(toDiBeanId);
                    //注入
                    field.setAccessible(true);//因为属性是private的，所以要将它accessible设为true
                    field.set(beanObj,obj);//userBizImpl.userDao = userDaoImpl
                }
            }
        }


    }

  //从beanMap 中找  是否singleton 是否lazy
    private Object getToDiBean(String toDiBeanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (beanMap.containsKey(toDiBeanId)){
           return beanMap.get(toDiBeanId);
        }
        //判断beanMap中没有此bean是否因为lazy
        if (!beanDefinitionMap.containsKey(toDiBeanId)){
            throw new RuntimeException("spring容器"+toDiBeanId);
        }
        YcBeanDefinition bd=  beanDefinitionMap.get(toDiBeanId);
        if (bd.isLazy()){
            //是因为lazy,所以没有托管
            String classPath = bd.getClassInfo();
            Object beanObj = Class.forName(classPath).newInstance();
            beanMap.put(toDiBeanId,beanObj);
            return beanObj;
        }

        //是否因为prototype
        if (bd.getScope().equalsIgnoreCase("prototype")){
            String classPath = bd.getClassInfo();
            Object beanObj = Class.forName(classPath).newInstance();
//            beanMap.put(toDiBeanId,beanObj);原型模式下  每次getBean在创建一次 所以beanMap不存
            return beanObj;
        }
        return null;
    }

    //循环beanDefinitionMap，创建bean(是否为懒加载，是单例)  存到beanMap
    private void createBean() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        for (Map.Entry<String,YcBeanDefinition> entry:beanDefinitionMap.entrySet()){
            String beanId = entry.getKey();
            YcBeanDefinition ybd = entry.getValue();
            if (!ybd.isLazy()&&!ybd.getScope().equalsIgnoreCase("prototype")){
                String classInfo = ybd.getClassInfo();
                Object obj = Class.forName(classInfo).newInstance();
                beanMap.put(beanId,obj);
                logger.trace("spring容器托管了"+beanId+"=>"+classInfo);

            }
        }
    }

    private void recursiveLoadBeanDefinition(String[] basePackages) {
        for (String basePackage:basePackages){//com.yc=>com/yc
            String packagePath = basePackage.replaceAll("\\.", "/");
            //target/classes/com/yc
            //Enumeration迭代器    URL:每个资源的路径
            try {
                Enumeration<URL> files = Thread.currentThread().getContextClassLoader().getResources(packagePath);
                //循环files
                while (files.hasMoreElements()) {
                    URL url = files.nextElement();
                    logger.trace("当前正在递归:" + url.getFile());
                    //查找此包下的类
                    findPackageClasses(url.getFile(),basePackage);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    private void findPackageClasses(String packagePath, String basePackage) {
        //路径异常处理
        if (packagePath.startsWith("/")){
            packagePath = packagePath.substring(1);

        }
        //取这个路径下所有的字节码文件
        File file = new File(packagePath);
        //只取后缀名为
        //写法一
//        File [] classFile = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if (pathname.getName().endsWith(".class")|| pathname.isDirectory()){
//                    return true;
//                }else {
//                    return false;
//                }
//            }
//        });
        File [] classFiles = file.listFiles((pathname)-> {
            if (pathname.getName().endsWith(".class") || pathname.isDirectory()) {
                return true;
            }
            return false;
        } );

        //循环此classFiles
        if (classFiles==null||classFiles.length<=0){
            return;
        }
        for (File cf:classFiles){
            if (cf.isDirectory()){
                logger.trace("递归:"+cf.getAbsolutePath()+"它对应的包名"+basePackage);
                findPackageClasses(cf.getAbsolutePath(),basePackage+"."+cf.getName());
            }else {
                //是class文件 ,则取出文件  判断此文件对应的class
                URLClassLoader uc = new URLClassLoader(new URL[]{});
                try {
                    Class cls = uc.loadClass(basePackage + "." + cf.getName().replaceAll(".class", ""));
                    if (cls.isAnnotationPresent(YcComponent.class )
                            ||cls.isAnnotationPresent(YcRepository.class)
                            ||cls.isAnnotationPresent(YcController.class )
                            ||cls.isAnnotationPresent(YcService.class)){
                        logger.info("加载到一个待托管的类:" + cls.getName());
                        YcBeanDefinition bd = new YcBeanDefinition();
                        if (cls.isAnnotationPresent(YcLazy.class)){
                            YcScope ycScope = (YcScope) cls.getAnnotation(YcScope.class);
                            String scope = ycScope.value();
                            bd.setScope(scope);
                        }
                        //实例化 cls.newInstance
                        bd.setClassInfo(basePackage+"."+cf.getName().replaceAll(".class",""));
                        //存到beanDefinitionMap  "beanId" ->"beanDefinitionMap"
                        String beanId = getBeanId(cls);
                        this.beanDefinitionMap.put(beanId,bd);
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }


    }

    /**
     *
     * 获取一个待托管类的id
     * 1.@Component  直接用类名（首字母小写）
     * 2.@Component  （”beanId“）
     *
     * 另外 @YcConfiguration  用全路径
     * @param cls
     * @return
     */

    private String getBeanId(Class cls) {
        YcComponent ycComponent = (YcComponent) cls.getAnnotation(YcComponent.class);
        YcService ycService = (YcService) cls.getAnnotation(YcService.class);
        YcRepository ycRepository = (YcRepository) cls.getAnnotation(YcRepository.class);
        YcController ycController = (YcController) cls.getAnnotation(YcController.class);

        YcConfiguration ycConfiguration = (YcConfiguration) cls.getAnnotation(YcConfiguration.class);

        if (ycConfiguration!=null){
            return cls.getSimpleName();
        }

        String beanId = null;
        if (ycComponent!=null){
           beanId = ycComponent.value();
        }  else if (ycController!=null){
            beanId = ycController.value();
        }else if (ycRepository!=null){
            beanId = ycRepository.value();
        }else if (ycService!=null){
            beanId = ycService.value();
        }
        if (beanId==null||"".equalsIgnoreCase(beanId)){
            String typename = cls.getSimpleName();
            logger.info("typename为:"+typename);
            beanId = typename.substring(0,1).toLowerCase()+typename.substring(1);
        }

        return beanId;
    }

    @Override
    public Object getBean(String beanid) {
        return null;
    }
}
