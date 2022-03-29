package com.jpanylee.common.exception.error;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private String errMsg;
    private Exception exception;

    public BaseException(String errMsg , Exception e) {
        this.errMsg = errMsg;
        this.exception = e;
    }

    public BaseException(String message, String errMsg, Exception exception) {
        super(message);
        this.errMsg = errMsg;
        this.exception = exception;
    }

    public BaseException(String message, Throwable cause, String errMsg, Exception exception) {
        super(message, cause);
        this.errMsg = errMsg;
        this.exception = exception;
    }

    public BaseException(Throwable cause, String errMsg, Exception exception) {
        super(cause);
        this.errMsg = errMsg;
        this.exception = exception;
    }
    public BaseException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

}
