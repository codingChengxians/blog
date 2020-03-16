package com.cloud.blog.auth.mapper;

import com.cloud.blog.auth.entity.SysPermission;
import com.cloud.blog.tkmybatis.mybatisconfig.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * (SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Mapper
public interface SysPermissionMapper extends MyMapper<SysPermission> {

    Set<String> selectPermissionByRoleId(Long roleId);
}