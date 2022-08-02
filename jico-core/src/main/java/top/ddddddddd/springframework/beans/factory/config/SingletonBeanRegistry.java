package top.ddddddddd.springframework.beans.factory.config;

/**
 * 单例Bean注册表
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:52
 * @Description:
 */
public interface SingletonBeanRegistry {

    //通过注册的beanName获取单例的Bean对象
    Object getSingleton(String beanName);


}
