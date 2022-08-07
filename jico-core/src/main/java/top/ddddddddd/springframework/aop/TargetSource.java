package top.ddddddddd.springframework.aop;

import top.ddddddddd.springframework.util.ClassUtils;

/**
 * 被代理的目标对象
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/05/22:38
 * @Description:
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * Return the type of targets returned by this {@link TargetSource}.
     * <p>Can return <code>null</code>, although certain usages of a
     * <code>TargetSource</code> might just work with a predetermined
     * target class.
     * @return the type of targets returned by this {@link TargetSource}
     */
    public Class<?>[] getTargetClass(){
        //判断cglib代理类
        Class<?> aClass = this.target.getClass();
        aClass = ClassUtils.isCglibProxyClass(aClass) ? aClass.getSuperclass() : aClass;
        return aClass.getInterfaces();
    }

    /**
     * Return a target instance. Invoked immediately before the
     * AOP framework calls the "target" of an AOP method invocation.
     * @return the target object, which contains the joinpoint
     * @throws Exception if the target object can't be resolved
     */
    public Object getTarget(){
        return this.target;
    }

}
