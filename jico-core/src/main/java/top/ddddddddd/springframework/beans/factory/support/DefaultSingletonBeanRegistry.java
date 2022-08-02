package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Bean容器注册表实现类
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:56
 * @Description:
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    //存放已经实例化的Bean
    private final Map<String,Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 向注册表中添加bean
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }
}
