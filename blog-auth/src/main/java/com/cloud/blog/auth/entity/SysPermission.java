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
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("sys_permission")
@Table(name="sys_permission")
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -95388148078964188L;
    
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Long id;
    
         
    @ApiModelProperty("parent_id")
    @Column(name = "parent_id")
    private Long parentId;
    
         
    @ApiModelProperty("name")
    @Column(name = "name")
    private String name;
    
         
    @ApiModelProperty("code")
    @Column(name = "code")
    private String code;
    
         
    @ApiModelProperty("icon")
    @Column(name = "icon")
    private String icon;
    
         
    @ApiModelProperty("status")
    @Column(name = "status")
    private Object status;
    
         
    @ApiModelProperty("create_time")
    @Column(name = "create_time")
    private Date createTime;
    
         
    @ApiModelProperty("sort")
    @Column(name = "sort")
    private Integer sort;
    
}