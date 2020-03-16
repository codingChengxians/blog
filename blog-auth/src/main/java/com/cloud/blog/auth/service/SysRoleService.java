package com.cloud.blog.auth.service;

import com.cloud.blog.auth.entity.SysRole;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service
public interface SysRoleService {
 PageInfo<SysRole> list(String filter, int pageIndex, int pageSize);

    void add(SysRole sysRole);

    void update(SysRole sysRole);

    void delete(Long id);

    SysRole get(Long id);

}