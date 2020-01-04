package com.miscloud;

import com.miscloud.entiy.Dept;
import com.netflix.discovery.converters.Auto;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
@MapperScan("com.miscloud.dao")
@EnableEurekaClient
public class DeptProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderApplication8001.class,args);
    }

}
