package com.cloud.blog.article.service;

import com.cloud.blog.article.entity.Article;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (Article)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 10:33:05
 */
@Service
public interface ArticleService {
 PageInfo<Article> list(String filter, int pageNum, int pageSize);

    void add(String title, String content);

    void update(Article article);

    void delete(Long id);

    Article get(Long id);

}