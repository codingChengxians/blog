package com.cloud.blog.auth.service;

import com.cloud.blog.auth.entity.SysAdminRoleRelation;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (SysAdminRoleRelation)表服务接口
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service
public interface SysAdminRoleRelationService {
 PageInfo<SysAdminRoleRelation> list(String filter, int pageIndex, int pageSize);

    void add(SysAdminRoleRelation sysAdminRoleRelation);

    void update(SysAdminRoleRelation sysAdminRoleRelation);

    void delete(Long id);

    SysAdminRoleRelation get(Long id);

}