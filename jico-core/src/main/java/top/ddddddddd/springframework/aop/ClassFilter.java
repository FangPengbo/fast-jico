package top.ddddddddd.springframework.aop;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/05/22:34
 * @Description:
 */
public interface ClassFilter {

    /**
     * 定义类匹配类，用于切点找到给定的接口和目标类。
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);

}
