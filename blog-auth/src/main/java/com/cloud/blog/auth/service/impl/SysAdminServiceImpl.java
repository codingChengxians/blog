package com.cloud.blog.auth.service.impl;

import com.cloud.blog.auth.entity.SysAdmin;
import com.cloud.blog.auth.entity.SysAdminRoleRelation;
import com.cloud.blog.auth.mapper.*;
import com.cloud.blog.auth.service.SysAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * (SysAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service("sysAdminService")
public class SysAdminServiceImpl implements SysAdminService, UserDetailsService {

    @Resource
    private SysAdminMapper sysAdminMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysAdminRoleRelationMapper sysAdminRoleRelationMapper;
    @Resource
    private SysRolePermissionRelationMapper sysRolePermissionRelationMapper;
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public PageInfo<SysAdmin> list(String filter, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysAdmin> sysAdmins = sysAdminMapper.selectAll();
        return PageInfo.of(sysAdmins);
    }

    @Override
    public void add(SysAdmin sysAdmin) {
        sysAdminMapper.insert(sysAdmin);
    }

    @Override
    public void update(SysAdmin sysAdmin) {
        sysAdminMapper.updateByPrimaryKey(sysAdmin);
    }

    @Override
    public void delete(Long id) {
        sysAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysAdmin get(Long id) {
        return sysAdminMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Example example = new Example(SysAdmin.class);
        example.createCriteria().andEqualTo("username", username);
        SysAdmin sysAdmin = sysAdminMapper.selectOneByExample(example);
        if (sysAdmin == null) {
            throw new UsernameNotFoundException("账号或者密码错误！");
        }
        Example example1 = new Example(SysAdminRoleRelation.class);
        example1.createCriteria().andEqualTo("adminId", sysAdmin.getId());
        SysAdminRoleRelation sysAdminRoleRelation = sysAdminRoleRelationMapper.selectOneByExample(example1);
        if (sysAdminRoleRelation != null) {
            Set<String> permission = sysPermissionMapper.selectPermissionByRoleId(sysAdminRoleRelation.getRoleId());
            sysAdmin.setAuthorities(AuthorityUtils.createAuthorityList(String.join(",",permission)));
        }
        return sysAdmin;
    }
}