package top.ddddddddd.springframework.core.convert.converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/07/14:09
 * @Description:
 */
public interface Converter<S,T> {

    T convert(S source);

}
