package com.yzw.rdpa.util;

import org.springframework.util.DigestUtils;

public class MD5Util {

    public static String getMD5(String str) {
        String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        return md5;
    }

    public static void main(String[] args) {
        //MD5Util md5Util = new MD5Util();
        System.out.println(MD5Util.getMD5("appid=rs2ca0fc6732ea48b&data=&format=json&method=rs.api.queryrssendreceiptinfolist&nonce=cb245afa402140dca50a7163af944d80&timestamp=20201224151031&version=1.0&appsecret=e53cdf21-477a-4593-9f7f-ceea2adb5fa3"));

    }
}
