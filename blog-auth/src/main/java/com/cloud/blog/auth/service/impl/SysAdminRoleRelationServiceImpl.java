package com.cloud.blog.auth.service.impl;

import com.cloud.blog.auth.service.SysAdminRoleRelationService;
import com.cloud.blog.auth.entity.SysAdminRoleRelation;
import com.cloud.blog.auth.mapper.SysAdminRoleRelationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;




/**
 * (SysAdminRoleRelation)表服务实现类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service("sysAdminRoleRelationService")
public class SysAdminRoleRelationServiceImpl implements SysAdminRoleRelationService {

    @Resource
    private SysAdminRoleRelationMapper sysAdminRoleRelationMapper;

    @Override
    public PageInfo<SysAdminRoleRelation> list(String filter, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysAdminRoleRelation> sysAdminRoleRelations = sysAdminRoleRelationMapper.selectAll();
        return PageInfo.of(sysAdminRoleRelations);
    }

    @Override
    public void add(SysAdminRoleRelation sysAdminRoleRelation) {
        sysAdminRoleRelationMapper.insert(sysAdminRoleRelation);
    }

    @Override
    public void update(SysAdminRoleRelation sysAdminRoleRelation) {
        sysAdminRoleRelationMapper.updateByPrimaryKey(sysAdminRoleRelation);
    }

    @Override
    public void delete(Long id) {
        sysAdminRoleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysAdminRoleRelation get(Long id) {
        return sysAdminRoleRelationMapper.selectByPrimaryKey(id);
    }
}