package top.ddddddddd.springframework.context.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.config.BeanPostProcessor;
import top.ddddddddd.springframework.context.ApplicationContext;
import top.ddddddddd.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:15
 * @Description:
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
