package com.example.secondhandmarket.util;

public class NumHelper {
    /* 判断字符串是否为数字 */
    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
}
