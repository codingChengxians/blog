package com.cloud.blog.article.controller;

import com.cloud.blog.article.service.UploadService;
import com.cloud.blog.core.exception.BusinessException;
import com.cloud.blog.core.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping("/images")
    public ApiResult uploadImages(@RequestParam("file") MultipartFile file) {
        if (file == null) {
            throw new BusinessException("请选择上传文件！");
        }
        String path =uploadService.uploadImages(file);
        return new ApiResult(path);
    }

}
