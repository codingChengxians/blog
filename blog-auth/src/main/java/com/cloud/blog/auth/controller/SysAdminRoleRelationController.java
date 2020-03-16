package com.cloud.blog.auth.controller;



import com.cloud.blog.auth.entity.SysAdminRoleRelation;
import com.cloud.blog.auth.service.SysAdminRoleRelationService;
import org.springframework.web.bind.annotation.*;

import com.cloud.blog.auth.dto.SysAdminRoleRelationSearchDto;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * (SysAdminRoleRelation)表控制层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@RestController
@RequestMapping("/api/sysAdminRoleRelation")
public class SysAdminRoleRelationController {
    /**
     * 服务对象
     */
    @Autowired
    private SysAdminRoleRelationService sysAdminRoleRelationService;

     @GetMapping("/list")
    public ApiResult<PageInfo<SysAdminRoleRelation>> selectAll(SysAdminRoleRelationSearchDto dto, PageDto pageDto) {
        return new ApiResult<PageInfo<SysAdminRoleRelation>>(this.sysAdminRoleRelationService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

   @GetMapping("/get")
    public ApiResult<SysAdminRoleRelation> get(long id) {
        return new ApiResult<SysAdminRoleRelation>(this.sysAdminRoleRelationService.get(id));
    }
    
    @PostMapping("/add")
    public ApiResult insert(@RequestBody SysAdminRoleRelation sysAdminRoleRelation) {
        sysAdminRoleRelationService.add(sysAdminRoleRelation);
        return new ApiResult();
    }
    @PostMapping("/update")
    public ApiResult update(@RequestBody SysAdminRoleRelation sysAdminRoleRelation) {
        this.sysAdminRoleRelationService.update(sysAdminRoleRelation);
        return new ApiResult();

    }
    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.sysAdminRoleRelationService.delete(id);
        return new ApiResult();
    }
}