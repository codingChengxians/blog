package com.cloud.blog.auth.controller;



import com.cloud.blog.auth.entity.SysRolePermissionRelation;
import com.cloud.blog.auth.service.SysRolePermissionRelationService;
import org.springframework.web.bind.annotation.*;

import com.cloud.blog.auth.dto.SysRolePermissionRelationSearchDto;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (SysRolePermissionRelation)表控制层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@RestController
@RequestMapping("/api/sysRolePermissionRelation")
public class SysRolePermissionRelationController {
    /**
     * 服务对象
     */
    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

     @GetMapping("/list")
    public ApiResult<PageInfo<SysRolePermissionRelation>> selectAll(SysRolePermissionRelationSearchDto dto, PageDto pageDto) {
        return new ApiResult<PageInfo<SysRolePermissionRelation>>(this.sysRolePermissionRelationService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

   @GetMapping("/get")
    public ApiResult<SysRolePermissionRelation> get(long id) {
        return new ApiResult<SysRolePermissionRelation>(this.sysRolePermissionRelationService.get(id));
    }
    
    @PostMapping("/add")
    public ApiResult insert(@RequestBody SysRolePermissionRelation sysRolePermissionRelation) {
        sysRolePermissionRelationService.add(sysRolePermissionRelation);
        return new ApiResult();
    }
    @PostMapping("/update")
    public ApiResult update(@RequestBody SysRolePermissionRelation sysRolePermissionRelation) {
        this.sysRolePermissionRelationService.update(sysRolePermissionRelation);
        return new ApiResult();

    }
    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.sysRolePermissionRelationService.delete(id);
        return new ApiResult();
    }
}