package com.cloud.blog.article.service.impl;

import com.cloud.blog.article.service.UploadService;
import com.cloud.blog.core.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String uploadImages(MultipartFile file) {
        String path = File.separator + "tmp" + File.separator + "images" + File.separator + LocalDate.now().toString() + File.separator;
        File dest = new File(path);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        try {
            dest = new File(path + file.getOriginalFilename());
            int up = 1;
            while (dest.exists()) {
                dest = new File(path +(repeatFile(file.getOriginalFilename(), up)));
                up = ++up;
            }
            file.transferTo(dest);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest.getPath();
    }

    private String repeatFile(String fileName, int up) {
        String[] split = fileName.split("\\.");
        if (split == null) {
            throw new BusinessException("请选择文件");
        }
        return split[0] + "(" + up + ")." + split[1];
    }

}
