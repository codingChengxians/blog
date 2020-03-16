package com.cloud.blog.auth.service;

import com.cloud.blog.auth.entity.SysAdmin;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * (SysAdmin)表服务接口
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@Service
public interface SysAdminService  {
 PageInfo<SysAdmin> list(String filter, int pageIndex, int pageSize);

    void add(SysAdmin sysAdmin);

    void update(SysAdmin sysAdmin);

    void delete(Long id);

    SysAdmin get(Long id);

}