package com.cloud.blog.auth.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("sys_role")
@Table(name="sys_role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -35210647860462341L;
    
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Long id;
    
         
    @ApiModelProperty("name")
    @Column(name = "name")
    private String name;
    
         
    @ApiModelProperty("descrption")
    @Column(name = "descrption")
    private String descrption;
    
         
    @ApiModelProperty("create_time")
    @Column(name = "create_time")
    private Date createTime;
    
         
    @ApiModelProperty("status")
    @Column(name = "status")
    private Object status;
    
         
    @ApiModelProperty("sort")
    @Column(name = "sort")
    private Integer sort;
    
}