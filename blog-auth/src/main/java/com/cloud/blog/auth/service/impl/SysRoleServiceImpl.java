package com.cloud.blog.auth.service.impl;

import com.cloud.blog.auth.service.SysRoleService;
import com.cloud.blog.auth.entity.SysRole;
import com.cloud.blog.auth.mapper.SysRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;




/**
 * (SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageInfo<SysRole> list(String filter, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysRole> sysRoles = sysRoleMapper.selectAll();
        return PageInfo.of(sysRoles);
    }

    @Override
    public void add(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.updateByPrimaryKey(sysRole);
    }

    @Override
    public void delete(Long id) {
        sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysRole get(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
}