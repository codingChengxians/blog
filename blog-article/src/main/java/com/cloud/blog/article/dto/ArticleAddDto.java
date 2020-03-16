package com.cloud.blog.article.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class ArticleAddDto implements Serializable {
    @NotBlank(message = "文章标题不能为空！")
    private String title;
    private String content;
}
