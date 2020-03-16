package com.cloud.blog.core.exception;

import org.springframework.validation.BindingResult;

public class BindingResultException extends RuntimeException {
    public BindingResultException(BindingResult bindingResult) {
        super(bindingResult.getFieldError().getDefaultMessage());
    }
}
