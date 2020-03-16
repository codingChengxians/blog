package com.cloud.blog.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

import java.time.LocalDateTime;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.cloud.blog.article.mapper.*")
public class BlogArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogArticleApplication.class, args);
    }

}
