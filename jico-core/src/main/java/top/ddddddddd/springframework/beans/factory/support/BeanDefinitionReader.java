package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.core.io.Resource;
import top.ddddddddd.springframework.core.io.ResourceLoader;

/**
 * 通过文件读取BeanDefinition顶层接口
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/22:40
 * @Description:
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
