package com.cloud.blog.core.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageDto implements Serializable {
    private int pageNum = 1;
    private int pageSize = 30;
}
