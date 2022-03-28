package com.jpanylee.common.exception.error;

import com.jpanylee.api.common.type.ErrorType;

public class NotFoundException extends BadRequestException {

    public NotFoundException(ErrorType ete, Exception exception) {
        super(ete, exception);
    }
    public NotFoundException(String message, ErrorType ete, Exception exception) {
        super(message, ete, exception);
    }
    public NotFoundException(ErrorType ete) {
        super(ete);
    }
}
