package top.ddddddddd.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.PropertyValue;
import top.ddddddddd.springframework.beans.PropertyValues;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;
import top.ddddddddd.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * 定义注册Bean的一系列操作
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:05
 * @Description:
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 创建完Bean注册进容器中
     * @throws BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinitio, Object[] args) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinitio,beanName,args);
            //给Bean填充属性
            applyPropertyValues(beanName, bean, beanDefinitio);

        } catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }

        addSingleton(beanName,bean);
        return bean;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructor = null;
        Class beanClass = beanDefinition.getBeanClass();
        //获取所有构造方法
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            //获取到对应参数个数的构造方法
            if (args != null && ctor.getParameterTypes().length == args.length){
                constructor = ctor;
                break;
            }
        }
        //通过cglib创建实例
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructor,args);
    }

    /**
     * Bean属性填充
     * @param bean
     * @param beanDefinitio
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinitio) {
        try {
            PropertyValues propertyValues = beanDefinitio.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference){
                    //获取这个属性在容器中的bean
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                //属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch (Exception e){
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }



}
