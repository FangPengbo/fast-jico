package top.ddddddddd.springframework.test;

import org.junit.Test;
import top.ddddddddd.springframework.beans.PropertyValue;
import top.ddddddddd.springframework.beans.PropertyValues;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;
import top.ddddddddd.springframework.beans.factory.config.BeanReference;
import top.ddddddddd.springframework.beans.factory.support.DefaultListableBeanFactory;
import top.ddddddddd.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import top.ddddddddd.springframework.context.support.ClassPathXmlApplicationContext;
import top.ddddddddd.springframework.test.bean.UserDao;
import top.ddddddddd.springframework.test.bean.UserService;
import top.ddddddddd.springframework.test.common.MyBeanFactoryPostProcessor;
import top.ddddddddd.springframework.test.common.MyBeanPostProcessor;

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
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

}
