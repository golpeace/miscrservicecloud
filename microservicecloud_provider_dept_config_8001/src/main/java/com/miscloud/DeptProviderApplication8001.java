package com.miscloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.miscloud.dao")
@EnableEurekaClient
public class DeptProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplication8001.class,args);
    }
}
