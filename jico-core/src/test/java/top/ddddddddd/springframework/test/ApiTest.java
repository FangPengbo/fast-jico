package top.ddddddddd.springframework.test;

import org.junit.Before;
import org.junit.Test;
import top.ddddddddd.springframework.aop.AdvisedSupport;
import top.ddddddddd.springframework.aop.TargetSource;
import top.ddddddddd.springframework.aop.aspectj.AspectJExpressionPointcut;
import top.ddddddddd.springframework.aop.framework.Cglib2AopProxy;
import top.ddddddddd.springframework.aop.framework.JdkDynamicAopProxy;
import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.PropertyValue;
import top.ddddddddd.springframework.beans.PropertyValues;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;
import top.ddddddddd.springframework.beans.factory.config.BeanPostProcessor;
import top.ddddddddd.springframework.beans.factory.config.BeanReference;
import top.ddddddddd.springframework.beans.factory.support.DefaultListableBeanFactory;
import top.ddddddddd.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import top.ddddddddd.springframework.context.support.ClassPathXmlApplicationContext;
import top.ddddddddd.springframework.test.bean.*;
import top.ddddddddd.springframework.test.common.MyBeanFactoryPostProcessor;
import top.ddddddddd.springframework.test.common.MyBeanPostProcessor;
import top.ddddddddd.springframework.test.event.CustomEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:14
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_beanPost(){

        BeanPostProcessor beanPostProcessor = new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                return null;
            }
        };

        List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.add(beanPostProcessor);
        beanPostProcessors.remove(beanPostProcessor);

        System.out.println(beanPostProcessors.size());
    }


}
