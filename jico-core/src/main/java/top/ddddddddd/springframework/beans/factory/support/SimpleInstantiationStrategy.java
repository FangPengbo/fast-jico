package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用JDK的 DeclaredConstructor实例化Bean
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:18
 * @Description:
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (ctor != null){
                //有参
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else {
                //无参
                return beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
