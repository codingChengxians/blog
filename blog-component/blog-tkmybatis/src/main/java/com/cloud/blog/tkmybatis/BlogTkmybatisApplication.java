package com.cloud.blog.tkmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
public class BlogTkmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogTkmybatisApplication.class, args);
    }

}
