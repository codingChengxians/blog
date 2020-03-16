package com.cloud.blog.auth.service;

import com.cloud.blog.auth.entity.SysRolePermissionRelation;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (SysRolePermissionRelation)表服务接口
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service
public interface SysRolePermissionRelationService {
 PageInfo<SysRolePermissionRelation> list(String filter, int pageIndex, int pageSize);

    void add(SysRolePermissionRelation sysRolePermissionRelation);

    void update(SysRolePermissionRelation sysRolePermissionRelation);

    void delete(Long id);

    SysRolePermissionRelation get(Long id);

}