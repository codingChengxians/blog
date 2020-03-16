package com.cloud.blog.core.exception;

import com.cloud.blog.core.result.ApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    private static final Integer SERVICE_ERROR = 500;

    public static final String EXCEPTION_MESSAGE = "服务器出了点小问题,请稍后重试";

    protected String getMessage(Exception e) {
        return null == e.getLocalizedMessage() ? EXCEPTION_MESSAGE : e.getLocalizedMessage();
    }

    @ResponseStatus
    @ExceptionHandler(value = BusinessException.class)
    public ApiResult businessException(BusinessException e) {
        return new ApiResult(ResultConstants.ERROR_UNKNOWN, e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ApiResult exception(Exception e) {
        return new ApiResult(SERVICE_ERROR, getMessage(e));

    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResult exception(IllegalArgumentException e) {
        return new ApiResult(ResultConstants.ERROR_ILLEGALPARAM, e.getMessage());

    }
    @ExceptionHandler(value = BindingResultException.class)
    public Map exception(BindingResultException e) {
        Map map = new HashMap(5);
        map.put("code",0);
        map.put("msg","错误！");
        return map;
    }
//    @ExceptionHandler(value = BindingResultException.class)
//    public ApiResult exception(BindingResultException e) {
//        return new ApiResult(ResultConstants.ERROR_ILLEGALPARAM, e.getMessage());
//    }

}
