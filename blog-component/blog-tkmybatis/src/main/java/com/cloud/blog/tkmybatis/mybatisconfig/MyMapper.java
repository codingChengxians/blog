package com.cloud.blog.tkmybatis.mybatisconfig;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author luok
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
