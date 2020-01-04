package com.miscloud;

import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigServer //表示是连接Git的服务端
public class DeptGitConfigApplication9520 {

    public static void main(String[] args) {
        SpringApplication.run(DeptGitConfigApplication9520.class,args);
    }
}
