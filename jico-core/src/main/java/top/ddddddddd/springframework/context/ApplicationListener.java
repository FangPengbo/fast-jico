package top.ddddddddd.springframework.context;

import java.util.EventListener;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/23:39
 * @Description:
 */
public interface ApplicationListener <E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);

}
