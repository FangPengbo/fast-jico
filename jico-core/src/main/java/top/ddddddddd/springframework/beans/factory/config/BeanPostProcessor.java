package top.ddddddddd.springframework.beans.factory.config;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * 用于修改新实例化 Bean 对象的扩展点
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/20:28
 * @Description:
 */
public interface BeanPostProcessor {


    /**
     * 在Bean对象执行初始化之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException;


    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     * @param object
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object object,String beanName) throws BeansException;

}
