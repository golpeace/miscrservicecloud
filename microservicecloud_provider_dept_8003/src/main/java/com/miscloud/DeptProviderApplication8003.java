package com.miscloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.miscloud.dao")
@EnableEurekaClient
public class DeptProviderApplication8003 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplication8003.class,args);
    }
}
