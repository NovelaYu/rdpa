package com.yzw.rdpa.service;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.entity.Sign;
import com.yzw.rdpa.util.ObjectToString;
import com.yzw.rdpa.util.SSLSocketClient;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HttpService {
    public static Response exceHttp(Object object,String method) {
        Sign sign = Sign.getSign();
        sign.setMethod(method);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                /**配置**/
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                /**忽略验证证书**/
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        FormBody.Builder form = new FormBody.Builder();
        //DeliveryReceipt deliveryReceipt = (DeliveryReceipt)object;
        form.add("appid",sign.getAppid());
        form.add("data", JSONObject.toJSONString(object));
        form.add("format",sign.getFormat());
        form.add("method",sign.getMethod());
        form.add("nonce",sign.getNonce());
        form.add("timestamp",sign.getTimestamp());
        form.add("version",sign.getVersion());
        form.add("sign", ObjectToString.objcetToString(object,sign));
        /**预发环境url**/
        String url = "https://api.jc.yzw.cn:8081/open.api";
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type","application/x-www-form-urlencoded")
                .post(form.build())
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
