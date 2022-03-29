package com.jpanylee.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer code;
    private String errMsg;
    private Boolean result;

    public static ErrorResponse getFailResult(Integer code, String errMsg) {
        return new ErrorResponse(code, errMsg,false);
    }

    public static ErrorResponse getFailResult(Integer code, String errMsg, Boolean result) {
        return new ErrorResponse(code, errMsg,false);
    }

}
