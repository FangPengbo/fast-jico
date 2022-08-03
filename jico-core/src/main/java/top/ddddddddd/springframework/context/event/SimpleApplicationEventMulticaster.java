package top.ddddddddd.springframework.context.event;

import top.ddddddddd.springframework.beans.factory.BeanFactory;
import top.ddddddddd.springframework.context.ApplicationEvent;
import top.ddddddddd.springframework.context.ApplicationListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/23:52
 * @Description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
