package com.feifei.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class MyBlogConfig7003
{
    public static void main(String[] args) {
        SpringApplication.run(MyBlogConfig7003.class,args);
    }
}
