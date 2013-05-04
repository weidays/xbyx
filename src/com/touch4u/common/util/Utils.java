package com.touch4u.common.util;

public class Utils
{
    /**
     * 如果s为null或者""返回true
     * @param s
     * @return
     */
public static boolean isNull(String s){
    if (s==null||"".equals(s)||"null".equals(s))
    {
       return true; 
    }
    return false; 
}
}
