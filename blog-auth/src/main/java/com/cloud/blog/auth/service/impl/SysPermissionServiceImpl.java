package com.cloud.blog.auth.service.impl;

import com.cloud.blog.auth.service.SysPermissionService;
import com.cloud.blog.auth.entity.SysPermission;
import com.cloud.blog.auth.mapper.SysPermissionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;




/**
 * (SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public PageInfo<SysPermission> list(String filter, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysPermission> sysPermissions = sysPermissionMapper.selectAll();
        return PageInfo.of(sysPermissions);
    }

    @Override
    public void add(SysPermission sysPermission) {
        sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public void update(SysPermission sysPermission) {
        sysPermissionMapper.updateByPrimaryKey(sysPermission);
    }

    @Override
    public void delete(Long id) {
        sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysPermission get(Long id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }
}