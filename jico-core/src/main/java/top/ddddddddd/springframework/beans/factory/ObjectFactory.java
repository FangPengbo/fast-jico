package top.ddddddddd.springframework.beans.factory;

import top.ddddddddd.springframework.beans.BeansException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/07/13:39
 * @Description:
 */
public interface ObjectFactory <T>{

    T getObject() throws BeansException;

}
