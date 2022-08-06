package top.ddddddddd.springframework.stereotype;

import java.lang.annotation.*;

/**
 * 用于配置到 Class 类上的
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/06/21:42
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";

}
