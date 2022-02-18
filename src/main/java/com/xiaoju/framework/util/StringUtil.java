package com.xiaoju.framework.util;

import java.util.LinkedList;

/**
 * StringUtil
 * 
 * @description: 字符串工具类
 **/
public class StringUtil {

    /**
     * 判断是否为空字符串最优代码
     * @param str
     * @return 如果为空，则返回true
     */
    public static boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }

    public static boolean isEmpty1(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(LinkedList<String> strs){
        for(String str: strs){
            if(str == null || str.trim().length() == 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否非空
     * @param str 如果不为空，则返回true
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    public static boolean isNotEmpty1(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isNotEmpty(LinkedList<String> str){
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否相等
     * @param str 如果相等，则返回true
     * @return
     */
    public static boolean isEqual(Object str1, Object str2) {
        if (str1 == str2 || str1.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isNotEqual(Object str1, Object str2){
        return !isEqual(str1,str2);
    }

    public static boolean isNotEqual1(Object str1, Object str2) {
        if (str1 == str2 || str1.equals(str2)) {
            return false;
        }
        return true;
    }

    /**
     * String结果对比，得到OK，NG
     * 
     * @param expectedResult
     * @param actualResult
     * @return
     */
    public static String assertResult(String expectedResult, String actualResult) {
        String result;
        if (expectedResult.equals(actualResult))
            result = "OK";
        else
            result = "NG";
        return result;
    }
}