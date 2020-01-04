package com.ribbonrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这个类是我们的自定义算法实现类，
 *
 *      注意：因为主启动类已经标注，所以这个类上面不需要添加任何注解
 *          倘若添加@Configuration注解，就会冲突，异常
 *
 */
public class MyRule extends AbstractLoadBalancerRule {

    @Autowired
    private ApplicationContext applicationContext;

    public MyRule(){

        System.out.println("MyRule 创建了。。。。-------");
    }
    private Integer currentIndex = 0;//当前服务的索引
    private Integer totalCount = 0;//服务被调用的总数

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                return null;
            }

            if (totalCount < 5) {
                server = allServers.get(currentIndex);
                totalCount++;
            } else {
                totalCount = 0;
                currentIndex = (currentIndex + 1) % serverCount;
            }

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }
        return server;
    }
}

//@Configuration
//public class MyRule{
//    public MyRule(){
//        System.out.println("MyRule 创建了。。。。");
//    }
//
//    @Bean
//    public IRule chooseRule(){
//        System.out.println("在创建规则");
//        return  new RandomRule();
//    }
//}
