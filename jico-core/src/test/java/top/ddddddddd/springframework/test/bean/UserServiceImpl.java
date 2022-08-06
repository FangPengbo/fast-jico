package top.ddddddddd.springframework.test.bean;

import top.ddddddddd.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/05/22:51
 * @Description:
 */
@Component("userService")
public class UserServiceImpl implements IUserService{

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
