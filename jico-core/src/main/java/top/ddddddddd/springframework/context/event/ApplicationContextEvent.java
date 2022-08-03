package top.ddddddddd.springframework.context.event;

import top.ddddddddd.springframework.context.ApplicationContext;
import top.ddddddddd.springframework.context.ApplicationEvent;

/**
 * ApplicationContextEvent 是定义事件的抽象类，所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类。
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/23:35
 * @Description:
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }

}
