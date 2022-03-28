package com.jpanylee.api.common.util;

import org.springframework.util.ObjectUtils;

public class ValidUtil {

    public static boolean isNullZero(Integer i) {
        return ObjectUtils.isEmpty(i) || i.intValue() == 0;
    }
}
