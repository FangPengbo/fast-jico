package top.ddddddddd.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import top.ddddddddd.springframework.beans.factory.config.BeanDefinition;
import top.ddddddddd.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/06/21:47
 * @Description:
 */
public class ClassPathScanningCandidateComponentProvider
{

    //通过这个方法就可以扫描到所有 @Component 注解的 Bean 对象了。
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
