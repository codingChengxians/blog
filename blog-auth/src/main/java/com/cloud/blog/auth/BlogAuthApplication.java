package com.cloud.blog.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(value = "com.cloud.blog.auth.mapper")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cloud.blog.*"})
public class BlogAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAuthApplication.class, args);
    }

}
