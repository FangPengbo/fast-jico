package top.ddddddddd.springframework.beans.factory;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * 定义操作Bean的接口
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:45
 * @Description: Bean工厂
 */
public interface BeanFactory {

    //通过注册的beanName获取Bean对象
    Object getBean(String name) throws BeansException;

    //通过构造参数获取Bean对象
    Object getBean(String name, Object... args) throws BeansException;

    //通过beanName和Bean类型获取Bean对象
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
