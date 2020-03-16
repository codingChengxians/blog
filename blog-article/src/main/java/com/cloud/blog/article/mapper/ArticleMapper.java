package com.cloud.blog.article.mapper;

import com.cloud.blog.article.entity.Article;
import com.cloud.blog.tkmybatis.mybatisconfig.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Article)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 10:33:05
 */

@Mapper
public interface ArticleMapper extends MyMapper<Article>{

}