package com.cloud.blog.auth.controller;


import com.cloud.blog.auth.dto.SysAdminSearchDto;
import com.cloud.blog.auth.entity.SysAdmin;
import com.cloud.blog.auth.service.SysAdminService;
import com.cloud.blog.core.exception.BindingResultException;
import com.cloud.blog.core.exception.BusinessException;
import com.cloud.blog.core.result.ApiResult;
import com.cloud.blog.core.result.PageDto;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * (SysAdmin)表控制层
 *
 * @author makejava
 * @since 2020-02-20 15:35:46
 */
@RestController
@RequestMapping("/api/sysAdmin")
public class SysAdminController {
    /**
     * 服务对象
     */
    @Autowired
    private SysAdminService sysAdminService;

    @GetMapping("/list")
    public ApiResult<PageInfo<SysAdmin>> selectAll(@Valid SysAdminSearchDto dto, PageDto pageDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
        return new ApiResult<PageInfo<SysAdmin>>(this.sysAdminService.list(dto.getFilter(), pageDto.getPageNum(), pageDto.getPageSize()));
    }

    @GetMapping("/get")
    public ApiResult<SysAdmin> get(long id) {
        return new ApiResult<SysAdmin>(this.sysAdminService.get(id));
    }

    @PostMapping("/add")
    public ApiResult insert(@RequestBody SysAdmin sysAdmin) {
        sysAdminService.add(sysAdmin);
        return new ApiResult();
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody SysAdmin sysAdmin) {
        this.sysAdminService.update(sysAdmin);
        return new ApiResult();

    }

    @RequestMapping("/delete")
    public ApiResult delete(Long id) {
        this.sysAdminService.delete(id);
        return new ApiResult();
    }
}