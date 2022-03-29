package com.jpanylee.api.common.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpanylee.api.common.type.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommResult {

    @JsonIgnore HttpStatus httpStatus;
    @JsonIgnore ResultCode resultCode;
    Map<String, Object> result = null;

    public CommResult(ResultCode result_code) {
        this.resultCode = result_code;
    }

    public CommResult(HttpStatus httpStatus, ResultCode resultCode) {
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    public static CommResult getDefResult() {
        return new CommResult(HttpStatus.OK, ResultCode.SUCCESS);
    }

    public static CommResult getResult(ResultCode result_code) {
        return new CommResult(result_code);
    }

    public void addObject(String key, Object value){
        if(result == null) result = new HashMap<String, Object>();
        result.put(key, value);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @JsonAnyGetter // json tree 를 한단계 상위로 끌어 올리기 위해 사용. 원래는 JsonUnWrapper 쓰면 될 것 같았지만.. Map 은 영향을 미치지 않는 다고 함.
    public Map<String, Object> getResult() {
        return result;
    }

    public ResponseEntity<?> getResponse(){
        if (result == null) {
            return new ResponseEntity<Object>(httpStatus);
        } else {
            return new ResponseEntity<Object>(result, httpStatus);
        }
    }
    
}
