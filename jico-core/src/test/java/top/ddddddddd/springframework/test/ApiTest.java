package top.ddddddddd.springframework.test;

import org.junit.Test;
import top.ddddddddd.springframework.aop.AdvisedSupport;
import top.ddddddddd.springframework.aop.TargetSource;
import top.ddddddddd.springframework.aop.aspectj.AspectJExpressionPointcut;
import top.ddddddddd.springframework.aop.framework.Cglib2AopProxy;
import top.ddddddddd.springframework.aop.framework.JdkDynamicAopProxy;
import top.ddddddddd.springframework.beans.PropertyValue;
import top.ddddddddd.springframework.beans.PropertyValues;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;
import top.ddddddddd.springframework.beans.factory.config.BeanReference;
import top.ddddddddd.springframework.beans.factory.support.DefaultListableBeanFactory;
import top.ddddddddd.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import top.ddddddddd.springframework.context.support.ClassPathXmlApplicationContext;
import top.ddddddddd.springframework.test.bean.*;
import top.ddddddddd.springframework.test.common.MyBeanFactoryPostProcessor;
import top.ddddddddd.springframework.test.common.MyBeanPostProcessor;
import top.ddddddddd.springframework.test.event.CustomEvent;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:14
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 目标对象
        IUserService userService = new UserServiceImpl();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* top.ddddddddd.springframework.test.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

}
