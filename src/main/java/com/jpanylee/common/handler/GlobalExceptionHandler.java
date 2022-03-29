package com.jpanylee.common.handler;

import com.jpanylee.api.common.type.ErrorType;
import com.jpanylee.common.exception.ErrorResponse;
import com.jpanylee.common.exception.error.BaseException;
import com.jpanylee.common.exception.error.ServerException;
import io.undertow.util.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 잘못된 요청
     **/
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BaseException.class)
    public ErrorResponse baseHandel(BaseException e) {
        log.error("BaseException : {} ", e.getErrMsg());
        return ErrorResponse.getFailResult(HttpStatus.OK.value(),e.getErrMsg(),false);
    }

    /**
     * catch 로 잡는 Server Exception
     **/
    @ExceptionHandler(ServerException.class)
    public ResponseEntity<?> handleServerException(ServerException e) {
        log.error("ServerException : {} ", e.getMessage());
        return ResponseEntity.status(e.getEtype().getStatus())
                .body(ErrorResponse.getFailResult(e.getEtype().getStatus(), e.getMessage()));
    }

    /**
     * 모든 Exception
     **/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        log.error("Exception : {} ", e);
        return ErrorResponse.getFailResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), ErrorType.INTERNAL_SERVER_ERROR.getErrMsg());
    }

    /**
     * 400 BAD_REQUEST 파라미터가 유효 하지 않는 경우
     **/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequestException(BadRequestException e){
        log.error("BadRequestException: {}", e.getMessage());
        return ErrorResponse.getFailResult(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 405 METHOD_NOT_ALLOWED 허용되지 않는 METHOD
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResponse handleNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.error("handleNotSupportedException: {}", e.getMessage());
        return ErrorResponse.getFailResult(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
