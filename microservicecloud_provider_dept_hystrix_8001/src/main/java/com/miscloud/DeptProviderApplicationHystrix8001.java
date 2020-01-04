package com.miscloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@MapperScan("com.miscloud.dao")
@EnableEurekaClient
//@EnableCircuitBreaker
public class DeptProviderApplicationHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplicationHystrix8001.class,args);
    }
}
