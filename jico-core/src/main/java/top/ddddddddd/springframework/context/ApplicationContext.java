package top.ddddddddd.springframework.context;

import top.ddddddddd.springframework.beans.factory.HierarchicalBeanFactory;
import top.ddddddddd.springframework.beans.factory.ListableBeanFactory;
import top.ddddddddd.springframework.core.io.ResourceLoader;

/**
 * 应用上下文
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/20:30
 * @Description:
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher{
}
