package top.ddddddddd.springframework.beans;

/**
 * 定义Bean的异常信息
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/20:47
 * @Description:
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
