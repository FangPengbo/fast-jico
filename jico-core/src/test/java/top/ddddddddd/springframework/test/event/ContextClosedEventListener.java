package top.ddddddddd.springframework.test.event;

import top.ddddddddd.springframework.context.ApplicationListener;
import top.ddddddddd.springframework.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
