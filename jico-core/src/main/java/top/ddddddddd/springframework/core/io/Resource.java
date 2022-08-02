package top.ddddddddd.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取资源的顶层接口，可以通过classpath、file、url
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/02/21:57
 * @Description:
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
