package com.cloud.blog.article.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (Article)实体类
 *
 * @author makejava
 * @since 2020-03-03 10:33:05
 */

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("article")
@Table(name="article")
public class Article implements Serializable {
    private static final long serialVersionUID = 163173280175990254L;
    
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Integer id;
    
         
    @ApiModelProperty("title")
    @Column(name = "title")
    private String title;
    
         
    @ApiModelProperty("content")
    @Column(name = "content")
    private String content;
    
         
    @ApiModelProperty("create_time")
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    
         
    @ApiModelProperty("update_time")
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

         
    @ApiModelProperty("images")
    @Column(name = "images")
    private String images;
    
}