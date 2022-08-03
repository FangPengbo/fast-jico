package top.ddddddddd.springframework.test.event;


import top.ddddddddd.springframework.context.ApplicationListener;
import top.ddddddddd.springframework.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
