package com.cloud.blog.article.service.impl;

import cn.hutool.core.util.StrUtil;
import com.cloud.blog.article.service.ArticleService;
import com.cloud.blog.article.entity.Article;
import com.cloud.blog.article.mapper.ArticleMapper;
import com.cloud.blog.tkmybatis.query.MapperQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


/**
 * (Article)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 10:33:05
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<Article> list(String filter, int pageNum, int pageSize) {
        PageInfo<Article> articlePageInfo = new MapperQuery<>(Article.class)
                .andLike("title", filter, !StrUtil.isEmpty(filter))
                .queryPage(articleMapper, pageNum, pageSize);
        return articlePageInfo;
    }

    @Override
    public void add(String title, String content) {
        Article article = new Article().setTitle(title).setContent(content).setCreateTime(LocalDateTime.now()).setUpdateTime(LocalDateTime.now());
        articleMapper.insertSelective(article);
    }

    @Override
    public void update(Article article) {
        articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public void delete(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Article get(Long id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}