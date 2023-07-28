package org.ycframework.context;

/**
 * 对一个Bean的了，特征的包装的类
 * 特征：singleton prototype
 *       lazy(true/false) 懒加载
 *       primary 主实例|优先实例    UserDao接口:@Primary UserDaoMybatisImpl类
 *       业务层：@Autowired
 *              @Autowired+@Primary
 * */
public class YcBeanDefinition {
    private  boolean isLazy;
    private  String scope = "singleton";
    private  boolean isPrimary;

    private String classInfo;//类的实例信息

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}

