package top.ddddddddd.springframework.beans.factory.config;

/**
 * Bean的引用，在创建Bean的时候要用到
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:40
 * @Description:
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
