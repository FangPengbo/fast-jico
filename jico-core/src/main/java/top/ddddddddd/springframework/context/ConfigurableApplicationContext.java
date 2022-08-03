package top.ddddddddd.springframework.context;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/20:32
 * @Description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext{


    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

}
