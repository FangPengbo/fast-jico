package top.ddddddddd.springframework.beans.factory;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/03/21:31
 * @Description:
 */
public interface DisposableBean {

    void destroy() throws Exception;

}
