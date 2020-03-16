package com.cloud.blog.auth.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;

@Data
public class SysRolePermissionRelationSearchDto implements Serializable {
    private static final long serialVersionUID = 243154815486666215L;
    private String filter;
}