package top.ddddddddd.springframework.context.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.ConfigurableListableBeanFactory;
import top.ddddddddd.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/20:44
 * @Description:
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{




    private DefaultListableBeanFactory beanFactory;

    /**
     * 在 refreshBeanFactory() 中主要是获取了 DefaultListableBeanFactory 的实例化以及对资源配置的加载操作 loadBeanDefinitions(beanFactory)，
     * 在加载完成后即可完成对 spring.xml 配置文件中 Bean 对象的定义和注册，同时也包括实现了接口 BeanFactoryPostProcessor、BeanPostProcessor 的配置 Bean 信息。
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);


    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }

}
