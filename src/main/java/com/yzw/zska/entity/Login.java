package com.yzw.zska.entity;

import com.alibaba.fastjson.JSONObject;
import com.yzw.zska.service.HttpService;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * 通过登录用户账号获取token
 */
public class Login {

    private String userName;
    private String passWord;
    private String token;
    private String url = "http://api.longfor.uat/cas-server-uat/cas/v1/token/createByUsernamePassword";

    public Login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    // todo 异常信息封装
    public String getCookie() {
        HashMap<String,String> map = new HashMap<>();
        map.put("username",userName);
        map.put("password",passWord);
        map.put("sysCode","ap-appcenter-open");

        HashMap<String,String> headersMap = new HashMap<>();
        headersMap.put("Content-Type","application/x-www-form-urlencoded");
        headersMap.put("X-Gaia-Api-Key","77698177-3bd9-45ba-9652-9f01c7f50364");

        Response response = HttpService.exceFromBodyHttp(map,headersMap,url);
        /** response.body().string() 只能使用一次，再次调用就会关闭 **/
        try {
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            if (("1").equals(jsonObject.getString("code"))) {
                //token = jsonObject.getJSONObject("data").getJSONObject("access_token").toString();
                JSONObject data = jsonObject.getJSONObject("data");
                token = data.getString("access_token");
            } else {
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;

    }

    public static void main(String[] args) {
        Login login = new Login("maoyxiang", "jsidkjfk.12");
        String cookie = login.getCookie();
        System.out.printf(cookie);

    }

}
