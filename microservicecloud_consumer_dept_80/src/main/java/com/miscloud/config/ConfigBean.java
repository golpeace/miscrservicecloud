package com.miscloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    /**
     * 8001 端口上的微服务是数据----提供者
     * 80 端口上的微服务是数据------消费者
     *
     * 我们在80端口的配置类上注入RestTemplate 对象
     * 当80项目启动之后就会加载这个类，创建这个对象。
     *
     * RestTemplate的作用：
     *  用于提供Restful服务的客户端访问类
     *
     * @return
     */

    @Bean
    @LoadBalanced //真正连接服务的对象，访问服务提供者的对象是RestTemplate,所以我们对这个对象添加负载均衡，让他自己去寻找连接服务提供者。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){

        System.out.println("这是ConfigBean 中的规则被创建了");
        /**
         * 我们需要什么算法只需要将Ribbon自带算法对象注入项目中即可
         *      默认是轮询算法：RoundRobinRule
         *      新注入的对象会将默认对象覆盖
         */
        return new RoundRobinRule();//项目中注入Ribbon的负载均衡策略，默认的轮询就会被覆盖
    }

}
