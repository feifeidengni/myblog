package com.feifei.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.feifei.myblog.repository")
public class MyBlogContents8003
{
    public static void main(String[] args) {
        SpringApplication.run(MyBlogContents8003.class,args);
    }
}
