package com.cloud.blog.auth.mapper;

import com.cloud.blog.auth.entity.SysAdmin;
import com.cloud.blog.tkmybatis.mybatisconfig.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */

@Mapper
public interface SysAdminMapper extends MyMapper<SysAdmin>{

}