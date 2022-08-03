package top.ddddddddd.springframework.beans.factory;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:12
 * @Description:
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;

}
