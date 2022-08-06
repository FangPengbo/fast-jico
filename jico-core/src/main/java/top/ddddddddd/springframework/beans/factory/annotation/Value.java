package top.ddddddddd.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/06/22:37
 * @Description:
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {


    /**
     * The actual value expression: e.g. "${systemProperties.myProp}".
     */
    String value();

}
