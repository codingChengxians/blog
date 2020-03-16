package com.cloud.blog.auth.entity;

import java.util.*;
import java.io.Serializable;

import io.swagger.annotations.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (SysAdmin)实体类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ApiModel("sys_admin")
@Table(name = "sys_admin")
public class SysAdmin implements UserDetails, Serializable {
    private static final long serialVersionUID = 848267179981219751L;

    @Id
    @KeySql(useGeneratedKeys = true)
    @ApiModelProperty("id")
    @Column(name = "id")
    private Long id;

    /**
     * 账号
     */
    @ApiModelProperty("username")
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("password")
    @Column(name = "password")
    private String password;

    /**
     * 盐
     */
    @ApiModelProperty("salt")
    @Column(name = "salt")
    private String salt;

    /**
     * 头像
     */
    @ApiModelProperty("icon")
    @Column(name = "icon")
    private String icon;

    /**
     * 电话
     */
    @ApiModelProperty("phone")
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("email")
    @Column(name = "email")
    private String email;

    /**
     * 昵称
     */
    @ApiModelProperty("nick_name")
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 描述
     */
    @ApiModelProperty("note")
    @Column(name = "note")
    private String note;

    /**
     * 创建时间
     */
    @ApiModelProperty("create_time")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登陆时间
     */
    @ApiModelProperty("login_time")
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 状态
     */
    @ApiModelProperty("status")
    @Column(name = "status")
    private Object status;

    private  Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}