package com.cloud.blog.auth.dto;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.*;

/**
 * @author luok
 */
@Data
public class SysAdminRoleRelationSearchDto implements Serializable {
    private static final long serialVersionUID = -17206696048165037L;

    @ApiModelProperty()
    private String filter;
}