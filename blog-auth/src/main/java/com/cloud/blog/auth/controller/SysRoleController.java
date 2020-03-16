package com.cloud.blog.auth.controller;



import com.cloud.blog.auth.entity.SysRole;
import com.cloud.blog.auth.service.SysRoleService;
import org.springframework.web.bind.annotation.*;

import com.cloud.blog.auth.dto.SysRoleSearchDto;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (SysRole)表控制层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@RestController
@RequestMapping("/api/sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Autowired
    private SysRoleService sysRoleService;

     @GetMapping("/list")
    public ApiResult<PageInfo<SysRole>> selectAll(SysRoleSearchDto dto, PageDto pageDto) {
        return new ApiResult<PageInfo<SysRole>>(this.sysRoleService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

   @GetMapping("/get")
    public ApiResult<SysRole> get(long id) {
        return new ApiResult<SysRole>(this.sysRoleService.get(id));
    }
    
    @PostMapping("/add")
    public ApiResult insert(@RequestBody SysRole sysRole) {
        sysRoleService.add(sysRole);
        return new ApiResult();
    }
    @PostMapping("/update")
    public ApiResult update(@RequestBody SysRole sysRole) {
        this.sysRoleService.update(sysRole);
        return new ApiResult();

    }
    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.sysRoleService.delete(id);
        return new ApiResult();
    }
}