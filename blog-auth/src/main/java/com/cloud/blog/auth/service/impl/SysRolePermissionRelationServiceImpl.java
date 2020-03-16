package com.cloud.blog.auth.service.impl;

import com.cloud.blog.auth.service.SysRolePermissionRelationService;
import com.cloud.blog.auth.entity.SysRolePermissionRelation;
import com.cloud.blog.auth.mapper.SysRolePermissionRelationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;




/**
 * (SysRolePermissionRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service("sysRolePermissionRelationService")
public class SysRolePermissionRelationServiceImpl implements SysRolePermissionRelationService {

    @Resource
    private SysRolePermissionRelationMapper sysRolePermissionRelationMapper;

    @Override
    public PageInfo<SysRolePermissionRelation> list(String filter, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysRolePermissionRelation> sysRolePermissionRelations = sysRolePermissionRelationMapper.selectAll();
        return PageInfo.of(sysRolePermissionRelations);
    }

    @Override
    public void add(SysRolePermissionRelation sysRolePermissionRelation) {
        sysRolePermissionRelationMapper.insert(sysRolePermissionRelation);
    }

    @Override
    public void update(SysRolePermissionRelation sysRolePermissionRelation) {
        sysRolePermissionRelationMapper.updateByPrimaryKey(sysRolePermissionRelation);
    }

    @Override
    public void delete(Long id) {
        sysRolePermissionRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysRolePermissionRelation get(Long id) {
        return sysRolePermissionRelationMapper.selectByPrimaryKey(id);
    }
}