package org.ycframework.context;

/**
 * 对一个Bean的了，特征的包装的类
 * 特征：singleton prototype
 *       lazy(懒加载)
 *       primary 主实例
 * */
public class YcBeanDefinition {
    private  boolean isLazy;
    private  String scope = "singleton";
    private  boolean isPrimary;

    private String classInfo;

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

