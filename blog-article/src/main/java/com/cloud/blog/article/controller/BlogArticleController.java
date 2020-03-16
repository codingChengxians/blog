package com.cloud.blog.article.controller;

import com.cloud.blog.article.entity.Article;
import com.cloud.blog.article.service.ArticleService;
import com.cloud.blog.article.service.impl.ArticleServiceImpl;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/blog")
@RestController
public class BlogArticleController {
    @Autowired
    private ArticleServiceImpl articleService;

    @RequestMapping("/list")
    public ApiResult<PageInfo<Article>> articlePage(PageDto pageDto){
        PageInfo<Article> list = articleService.list(null, pageDto.getPageNum(), pageDto.getPageSize());
        return  new ApiResult<>(list);
    }
}
