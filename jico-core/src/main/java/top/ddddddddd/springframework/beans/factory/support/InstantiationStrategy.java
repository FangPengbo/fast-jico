package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean的实例化策略
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:16
 * @Description:
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
