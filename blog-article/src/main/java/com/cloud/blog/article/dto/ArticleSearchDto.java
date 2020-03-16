package com.cloud.blog.article.dto;

import java.util.Date;
import java.io.Serializable;
import lombok.*;

@Data
public class ArticleSearchDto implements Serializable {
    private static final long serialVersionUID = 135398565619524131L;
    
    private String filter;
}