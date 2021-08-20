package com.yzw.zska.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Sign {
    private  String appid;
    private  String format;
    private  String nonce;
    private  String version ;
    private  String appsecret ;
    private String method;
    private String timestamp;

    public static Sign getSign() {
        Sign sign = new Sign();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHMMSS");
        sign.setTimestamp(sdf.format(new Date()));
        /**正式环境**/
        //sign.setAppid("RSC7FDD72EDB5C475");
        /**测试环境**/
        sign.setAppid("RS2CA0FC6732EA48B");
        sign.setFormat("json");
        //sign.setMethod("RS.API.QueryRSSendReceiptInfoList");
        sign.setNonce("cdd39b43425c440d8f6f07abb0521bda");
        sign.setVersion("1.0");
        /**正式环境**/
        //sign.setAppsecret("89430CE8-1D18-4626-BF00-062A37B34057");
        /**测试环境**/
        sign.setAppsecret("E53CDF21-477A-4593-9F7F-CEEA2ADB5FA3");
        return sign;
    }
}
