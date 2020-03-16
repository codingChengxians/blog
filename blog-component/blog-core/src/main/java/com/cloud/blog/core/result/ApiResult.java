package com.cloud.blog.core.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@ApiModel("API结果")
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiParam(value = "返回值，<0代表失败，=0代表成功，>0代表成功但有警告", required = true)
    private Integer code = 0;
    @ApiParam(value = "错误信息或者警告信息")
    private String message = null;
    @ApiParam(value = "调用结果")
    private T result = null;
    @ApiParam(value = "分页信息")
    private PageInfo<T> page = null;
    public ApiResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResult(T result) {
        this.result = result;
    }

    public ApiResult(int code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
