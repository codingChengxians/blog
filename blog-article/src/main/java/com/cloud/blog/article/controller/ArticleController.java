package com.cloud.blog.article.controller;


import com.cloud.blog.article.dto.ArticleAddDto;
import com.cloud.blog.article.dto.ArticleSearchDto;
import com.cloud.blog.article.entity.Article;
import com.cloud.blog.article.service.ArticleService;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (Article)表控制层
 *
 * @author makejava
 * @since 2020-03-03 10:33:05
 */
@Slf4j
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    /**
     * 服务对象
     */

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public ApiResult<PageInfo<Article>> selectAll(ArticleSearchDto dto, PageDto pageDto) {
        return new ApiResult<PageInfo<Article>>(this.articleService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

    @GetMapping("/get")
    public ApiResult<Article> get(long id) {
        return new ApiResult<Article>(this.articleService.get(id));
    }

    @PostMapping("/add")
    public ApiResult insert(@Valid @RequestBody ArticleAddDto dto) {
        this.articleService.add(dto.getTitle(), dto.getContent());
        return new ApiResult();
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody Article article) {
        this.articleService.update(article);
        return new ApiResult();

    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.articleService.delete(id);
        return new ApiResult();
    }
}