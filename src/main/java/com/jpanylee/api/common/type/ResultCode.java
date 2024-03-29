package com.jpanylee.api.common.type;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum ResultCode {
    SUCCESS(200)
    , UNKNOWN(999);   // valueOf() 예외처리용


    int value;

    ResultCode(int value) {
        this.value = value;
    }

    public static ResultCode valueOf(int value) {
        for (ResultCode e : values()) {
            if (Objects.equals(e.getValue(), value)) {
                return e;
            }
        }
        return UNKNOWN;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
