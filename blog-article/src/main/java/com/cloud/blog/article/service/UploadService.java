package com.cloud.blog.article.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {
    String uploadImages(MultipartFile file);
}
