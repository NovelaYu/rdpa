package com.yzw.rdpa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**获取当前时间毫秒**/
    public static String getCurrentMilliSeconds() {
        long currentTimeMillis=System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss:hs");
        return format.format(new Date(currentTimeMillis));

    }

    public static Date getCurrentDate() {
        return new Date();
    }


    public static void main(String[] args) {
        System.out.println(DateUtil.getCurrentMilliSeconds());
    }

}
