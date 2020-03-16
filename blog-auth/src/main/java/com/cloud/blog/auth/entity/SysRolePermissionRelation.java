package com.cloud.blog.auth.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (SysRolePermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("sys_role_permission_relation")
@Table(name="sys_role_permission_relation")
public class SysRolePermissionRelation implements Serializable {
    private static final long serialVersionUID = 619878019505529385L;
    
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Long id;
    
         
    @ApiModelProperty("role_id")
    @Column(name = "role_id")
    private Long roleId;
    
         
    @ApiModelProperty("permission_id")
    @Column(name = "permission_id")
    private Long permissionId;
    
}