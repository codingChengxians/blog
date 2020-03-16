package com.cloud.blog.core.exception;


public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 28276149133604363L;
    private int errorCode = ResultConstants.ERROR_BUSINESSERROR;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
