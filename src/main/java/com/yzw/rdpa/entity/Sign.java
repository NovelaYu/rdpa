package com.yzw.rdpa.entity;

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
        sign.setAppid("RSC7FDD72EDB5C475");
        sign.setFormat("json");
        //sign.setMethod("RS.API.QueryRSSendReceiptInfoList");
        sign.setNonce("cdd39b43425c440d8f6f07abb0521bda");
        sign.setVersion("1.0");
        sign.setAppsecret("89430CE8-1D18-4626-BF00-062A37B34057");
        return sign;
    }
}
