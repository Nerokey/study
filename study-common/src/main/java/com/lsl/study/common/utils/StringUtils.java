package com.lsl.study.common.utils;

public class StringUtils {

    public static boolean isEmpty(String input) {
        return (input == null) || (input.trim().length() == 0);
    }

}
