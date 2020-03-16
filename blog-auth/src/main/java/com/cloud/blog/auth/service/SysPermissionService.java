package com.cloud.blog.auth.service;

import com.cloud.blog.auth.entity.SysPermission;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (SysPermission)表服务接口
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service
public interface SysPermissionService {
 PageInfo<SysPermission> list(String filter, int pageIndex, int pageSize);

    void add(SysPermission sysPermission);

    void update(SysPermission sysPermission);

    void delete(Long id);

    SysPermission get(Long id);

}