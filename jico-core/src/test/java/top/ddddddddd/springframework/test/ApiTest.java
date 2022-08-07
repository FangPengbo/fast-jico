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
    public void test_autoProxy() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
