package top.ddddddddd.springframework.context.support;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * 具体对外给用户提供的应用上下文方法。
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/20:51
 * @Description:
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }


    public ClassPathXmlApplicationContext(String [] configLocations) throws BeansException{
        this.configLocations = configLocations;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException{
        this(new String[]{configLocations});
    }


}
