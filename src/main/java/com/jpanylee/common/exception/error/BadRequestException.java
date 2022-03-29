package com.jpanylee.common.exception.error;

import com.jpanylee.api.common.type.ErrorType;

public class BadRequestException extends RuntimeException{
    private ErrorType etype;
    private Exception exception;

    public BadRequestException(ErrorType etype) {
        super(etype.getErrMsg());
        this.etype = etype;
    }
    public BadRequestException(ErrorType etype, Exception exception) {
        this.etype = etype;
        this.exception = exception;
    }

    public BadRequestException(String msg, ErrorType etype, Exception exception) {
        super(msg);
        this.etype = etype;
        this.exception = exception;
    }
}
