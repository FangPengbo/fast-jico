package top.ddddddddd.springframework.beans.factory.support;

import top.ddddddddd.springframework.beans.BeansException;
import top.ddddddddd.springframework.beans.factory.DisposableBean;
import top.ddddddddd.springframework.beans.factory.ObjectFactory;
import top.ddddddddd.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean容器注册表实现类
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:56
 * @Description:
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     */
    protected static final Object NULL_OBJECT = new Object();

    //一级缓存，普通对象
    private final Map<String,Object> singletonObjects = new HashMap<>();

    //二级缓存，提前暴露对象，没有完全实例化的对象
    protected final Map<String,Object> earlySingletonObjects = new HashMap<>();

    //三级缓存，存放代理对象
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();

    //存放实现了DisposableBean的Bean
    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        //先从一级缓存中取
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject){
            singletonObject = earlySingletonObjects.get(beanName);
            //判断二级缓存中是否有对象，这个对象就是代理对象，因为只有代理对象才会放到三级缓存中
            if (null == singletonObject){
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null){
                    singletonObject = singletonFactory.getObject();
                    //把三级缓存中的代理对象中的真实对象取出来，放入二级缓存中
                    earlySingletonObjects.put(beanName,singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    /**
     * 向注册表中添加bean
     * @param beanName
     * @param singletonObject
     */
    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }


    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory){
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }


    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }


}
