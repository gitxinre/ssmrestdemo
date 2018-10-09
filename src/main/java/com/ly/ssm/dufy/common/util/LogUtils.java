package com.ly.ssm.dufy.common.util;

/**
 * @author Administrator
 * 3-46
 */
public class LogUtils {
    public static String myLogFormat(String logInfo){
        StringBuffer sb = new StringBuffer();
        sb.append("--- ");
        sb.append(logInfo);
        sb.append(" ----------------------------------------------");
        return sb.toString();
    }
}
