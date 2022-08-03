package top.ddddddddd.springframework.context.event;

/**
 * 关闭动作
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/23:36
 * @Description:
 */
public class ContextClosedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
