package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.BeanFactory;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean工厂的实现类，与单例Bean注册表结合
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:56
 * @Description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args){
        Object singleton = getSingleton(name);
        if (singleton != null){
            return (T) singleton;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }

    protected abstract Object createBean(String name, BeanDefinition beanDefinitio, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String name) throws BeansException;

}
