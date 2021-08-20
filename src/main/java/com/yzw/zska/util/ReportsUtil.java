package com.yzw.zska.util;


import org.testng.Reporter;

import java.util.Calendar;

/**对时间日志记录时间特殊处理**/
public class ReportsUtil {
    private static String reportName = "收验货系统接口自动化测试报告";

    private static String splitTimeAndMsg = "===";

    public static void log(String msg) {
        long timeMillis = Calendar.getInstance().getTimeInMillis();
        Reporter.log(timeMillis + splitTimeAndMsg + msg, true);
    }

    public static void log(String msg,boolean flag) {
        long timeMillis = Calendar.getInstance().getTimeInMillis();
        Reporter.log(timeMillis + splitTimeAndMsg + msg, flag);
    }


    public static String getReportName() {
        return reportName;
    }

    public static String getSpiltTimeAndMsg() {
        return splitTimeAndMsg;
    }


}
