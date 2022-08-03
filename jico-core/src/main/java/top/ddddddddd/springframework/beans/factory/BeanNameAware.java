package top.ddddddddd.springframework.beans.factory;

/**
 * 实现此接口，既能感知到所属的 BeanName
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:13
 * @Description:
 */
public interface BeanNameAware extends Aware{

    void setBeanName(String name);

}
