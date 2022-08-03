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
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}
