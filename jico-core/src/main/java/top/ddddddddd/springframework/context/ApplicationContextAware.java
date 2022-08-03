package top.ddddddddd.springframework.context;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.Aware;

/**
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:14
 * @Description:
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;

}
