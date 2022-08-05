package top.ddddddddd.springframework.aop;

/**
 * PointcutAdvisor 承担了 Pointcut 和 Advice 的组合，Pointcut 用于获取 JoinPoint，而 Advice 决定于 JoinPoint 执行什么操作。
 *
 * @Author: Fang Pengbo
 * @Date: 2022/08/05/23:11
 * @Description:
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();

}
