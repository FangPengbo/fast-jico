package top.ddddddddd.springframework.beans.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 使用cglib实例化Bean
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:22
 * @Description:
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null){
            //无参
            return enhancer.create();
        }
        //有参
        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
