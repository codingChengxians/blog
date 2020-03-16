package com.cloud.blog.auth.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;

@Data
public class SysPermissionSearchDto implements Serializable {
    private static final long serialVersionUID = 259501966921157180L;
    private String filter;
}