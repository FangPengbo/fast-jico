package top.ddddddddd.springframework.beans.factory;

/**
 *实现此接口，既能感知到所属的 ClassLoader
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/22:13
 * @Description:
 */
public interface BeanClassLoaderAware extends Aware{

    void setBeanClassLoader(ClassLoader classLoader);

}
