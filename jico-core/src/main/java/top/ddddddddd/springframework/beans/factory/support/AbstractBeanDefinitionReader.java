package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.core.io.DefaultResourceLoader;
import top.ddddddddd.springframework.core.io.ResourceLoader;

/**
 * 实现部分公用的ResourceReader接口供具体实现类使用
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/22:40
 * @Description:
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry,new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry,ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
