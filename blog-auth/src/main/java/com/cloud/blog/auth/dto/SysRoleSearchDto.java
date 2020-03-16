package com.cloud.blog.auth.dto;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;

@Data
public class SysRoleSearchDto implements Serializable {
    private static final long serialVersionUID = -95039494590450957L;
    private String filter;
}