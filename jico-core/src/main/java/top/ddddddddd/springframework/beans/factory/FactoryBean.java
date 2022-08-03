package top.ddddddddd.springframework.beans.factory;

/**
 * FactoryBean 中需要提供3个方法，获取对象、对象类型，以及是否是单例对象，如果是单例对象依然会被放到内存中。
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:39
 * @Description:
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
