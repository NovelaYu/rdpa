package com.yzw.rdpa.util;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.entity.Sign;

import java.text.SimpleDateFormat;

public class ObjectToString {
    public static String objcetToString(Object object, Sign sign) {
        /**StringBuilder 非线程安全**/
        StringBuilder builder = new StringBuilder();
        String data = JSONObject.toJSONString(object);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMSS");
        //String timestamp  = sdf.format(new Date());
        builder.append("appid=").append(sign.getAppid());
        builder.append("&data=").append(data);
        builder.append("&format=").append(sign.getFormat());
        builder.append("&method=").append(sign.getMethod());
        builder.append("&nonce=").append(sign.getNonce());
        builder.append("&timestamp=").append(sign.getTimestamp());
        builder.append("&version=").append(sign.getVersion());
        builder.append("&appsecret=").append(sign.getAppsecret());
        //System.out.println(builder.toString().toLowerCase());
        String md5=MD5Util.getMD5(builder.toString().toLowerCase());
        //builder.append("&sign=").append(md5);
        return md5;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMSS");
        //System.out.println(sdf.format(new Date()));
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        Sign sign = new Sign();
        sign.setAppid("RS2CA0FC6732EA48B");
        sign.setFormat("json");
        sign.setMethod("RS.API.QueryRSSendReceiptInfoList");
        sign.setNonce("cb245afa402140dca50a7163af944d80");
        sign.setTimestamp("20201224151031");
        sign.setVersion("1.0");
        sign.setAppsecret("E53CDF21-477A-4593-9F7F-CEEA2ADB5FA3");
        System.out.println(ObjectToString.objcetToString(deliveryReceipt,sign));
    }


}
