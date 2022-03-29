package com.jpanylee.common.exception.error;

import com.jpanylee.api.common.type.ErrorType;
import lombok.Getter;

@Getter
public class ServerException extends RuntimeException {
    private ErrorType etype;
    private Exception exception;

    public ServerException() {
        super(ErrorType.INTERNAL_SERVER_ERROR.getErrMsg());
        this.etype = ErrorType.INTERNAL_SERVER_ERROR;
    }
    public ServerException(ErrorType etype) {
        super(etype.getErrMsg());
        this.etype = etype;
    }
    public ServerException(ErrorType etype , Exception exception) {
        super(etype.getErrMsg());
        this.etype = etype;
        this.exception = exception;
    }
    public ServerException(Exception e){
        super(e);
    }
}
