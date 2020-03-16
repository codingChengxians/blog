package com.cloud.blog.auth.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SysAdminSearchDto implements Serializable {
    private static final long serialVersionUID = -30394640413535998L;
    @NotNull(message = "{user.name.notBlank}")
    private String filter;
}