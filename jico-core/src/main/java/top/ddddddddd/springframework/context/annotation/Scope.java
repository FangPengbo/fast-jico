package top.ddddddddd.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * 用于配置作用域的自定义注解，方便通过配置Bean对象注解的时候，拿到Bean对象的作用域。不过一般都使用默认的 singleton
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/06/21:37
 * @Description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})//注解用于类、接口、注解、enum、方法上
@Retention(RetentionPolicy.RUNTIME)//什么时候使用该注解
@Documented//注解是否将包含在JavaDoc中
public @interface Scope {

    String value() default "singleton";


}
