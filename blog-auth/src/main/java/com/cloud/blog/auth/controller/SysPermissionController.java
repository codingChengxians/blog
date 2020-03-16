package com.cloud.blog.auth.controller;



import com.cloud.blog.auth.entity.SysPermission;
import com.cloud.blog.auth.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import com.cloud.blog.auth.dto.SysPermissionSearchDto;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (SysPermission)表控制层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@RestController
@RequestMapping("/api/sysPermission")
public class SysPermissionController {
    /**
     * 服务对象
     */
    @Autowired
    private SysPermissionService sysPermissionService;

     @GetMapping("/list")
    public ApiResult<PageInfo<SysPermission>> selectAll(SysPermissionSearchDto dto, PageDto pageDto) {
        return new ApiResult<PageInfo<SysPermission>>(this.sysPermissionService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

   @GetMapping("/get")
    public ApiResult<SysPermission> get(long id) {
        return new ApiResult<SysPermission>(this.sysPermissionService.get(id));
    }
    
    @PostMapping("/add")
    public ApiResult insert(@RequestBody SysPermission sysPermission) {
        sysPermissionService.add(sysPermission);
        return new ApiResult();
    }
    @PostMapping("/update")
    public ApiResult update(@RequestBody SysPermission sysPermission) {
        this.sysPermissionService.update(sysPermission);
        return new ApiResult();

    }
    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.sysPermissionService.delete(id);
        return new ApiResult();
    }
}