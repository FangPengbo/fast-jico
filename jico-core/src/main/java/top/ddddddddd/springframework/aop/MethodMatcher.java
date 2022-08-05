package top.ddddddddd.springframework.aop;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/05/22:34
 * @Description:
 */
public interface MethodMatcher {

    /**
     * 方法匹配，找到表达式范围内匹配下的目标类和方法。
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);

}
