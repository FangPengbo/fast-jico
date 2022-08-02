package top.ddddddddd.springframework.core.io;

/**
 * 获取Resource接口
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/22:33
 * @Description:
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
