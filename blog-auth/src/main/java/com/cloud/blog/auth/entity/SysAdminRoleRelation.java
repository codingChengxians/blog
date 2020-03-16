package com.cloud.blog.auth.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (SysAdminRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("sys_admin_role_relation")
@Table(name="sys_admin_role_relation")
public class SysAdminRoleRelation implements Serializable {
    private static final long serialVersionUID = -16840855433079598L;
    
    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Long id;
    
         
    @ApiModelProperty("admin_id")
    @Column(name = "admin_id")
    private Long adminId;
    
         
    @ApiModelProperty("role_id")
    @Column(name = "role_id")
    private Long roleId;
    
}