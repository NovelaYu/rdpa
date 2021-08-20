package com.yzw.zska.service;

import com.yzw.zska.util.DateUtil;
import com.yzw.zska.util.ReportsUtil;
import com.yzw.zska.util.SSLSocketClient;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpService {


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    /**传入json数据，post提交**/
    public static Response exceJsonHttp(String json,HashMap<String,String> headerMap,String url) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                /**配置**/
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                /**忽略验证证书**/
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        RequestBody body = RequestBody.create(JSON, json);
        /**将调用当前接口的开始时间记录到报告**/
        ReportsUtil.log("开始调用http接口: " + DateUtil.getCurrentMilliSeconds());

        Headers.Builder headers = new Headers.Builder();
        /**循环获取header 表单中的值**/
        if (headers != null) {
            for (String key : headerMap.keySet()) {
                headers.add(key,headerMap.get(key));
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .headers(headers.build())
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = null;
        try {
            /**同步调用
             * 异步 all.enqueue(new Callback() {}
             * 同步哦 new callback 执行回调
             * **/
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**将调用当前接口的结束时间记录到报告**/
            ReportsUtil.log("http接口调用结束: " + DateUtil.getCurrentMilliSeconds());
        }
        return response;
    }

    /**传入From 表单数据，post提交**/
    public static Response exceFromBodyHttp(HashMap<String,String> map,HashMap<String,String> headerMap, String url) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                /**配置**/
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                /**忽略验证证书**/
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();

        FormBody.Builder form = new FormBody.Builder();

        /**循环获取map表单中值**/
        if (map != null) {
            for (String key : map.keySet()) {
                form.add(key,map.get(key));
            }
        }

        Headers.Builder headers = new Headers.Builder();
        /**循环获取header 表单中的值**/
        if (headers != null) {
            for (String key : headerMap.keySet()) {
                headers.add(key,headerMap.get(key));
            }
        }

        /**将调用当前接口的开始时间记录到报告**/
        ReportsUtil.log("开始调用http接口: " + DateUtil.getCurrentMilliSeconds());

        Request request = new Request.Builder()
                .url(url)
                .headers(headers.build())
                .post(form.build())
                .build();
        Call call = client.newCall(request);
        Response response = null;
        try {
            /**同步调用
             * 异步 call.enqueue(new Callback() {}
             * 同步哦 new callback 执行回调
             * **/
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**将调用当前接口的结束时间记录到报告**/
            ReportsUtil.log("http接口调用结束: " + DateUtil.getCurrentMilliSeconds());
        }
        return response;
    }



    /**get请求**/
    public static Response getHttp(HashMap<String,String> map,HashMap<String,String> headerMap, String url) {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .writeTimeout(2000, TimeUnit.MILLISECONDS)
                /**配置**/
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                /**忽略验证证书**/
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();

        Headers.Builder headers = new Headers.Builder();
        /**循环获取header 表单中的值**/
        if (headers != null) {
            for (String key : headerMap.keySet()) {
                headers.add(key, headerMap.get(key));
            }
        }

        /**封装url 参数请求**/
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        if (map != null) {
            for (Map.Entry<String, String> param : map.entrySet()) {
                httpBuilder.addQueryParameter(param.getKey(), param.getValue());
            }
        }
            /**将调用当前接口的开始时间记录到报告**/
            ReportsUtil.log("开始调用http接口: " + DateUtil.getCurrentMilliSeconds());

            Request request = new Request.Builder()
                    .url(httpBuilder.build())
                    .headers(headers.build())
                    .build();
            Call call = client.newCall(request);
            Response response = null;
            try {
                /**同步调用
                 * 异步 call.enqueue(new Callback() {}
                 * 同步哦 new callback 执行回调
                 * **/
                response = call.execute();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                /**将调用当前接口的结束时间记录到报告**/
                ReportsUtil.log("http接口调用结束: " + DateUtil.getCurrentMilliSeconds());
            }

        return response;
    }

        /***文件上传**/
        //todo
   /* public static Response execFileHttp() {
        File file=new File("Environment.getExternalStorageDirectory()", "balabala.png");
        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        RequestBody filebody = MultipartBody.create(MEDIA_TYPE_PNG, file);
        MultipartBody.Builder multiBuilder=new MultipartBody.Builder();
        //这里是 封装上传图片参数
        multiBuilder.addFormDataPart("file", file.getName(), filebody);
        //参数以添加header方式将参数封装，否则上传参数为空
        // 设置请求体
        multiBuilder.setType(MultipartBody.FORM);
        //这里是 封装上传图片参数
        multiBuilder.addFormDataPart("file", file.getName(), filebody);
        // 封装请求参数,这里最重要
        HashMap<String, String> params = new HashMap<>();
        params.put("client","Android");
        params.put("uid","1061");
        params.put("token","1911173227afe098143caf4d315a436d");
        params.put("uuid","A000005566DA77");
        //参数以添加header方式将参数封装，否则上传参数为空
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                multiBuilder.addPart(
                        Headers.of("Content-Disposition", "form-data; name=\"" + key + "\""),
                        RequestBody.create(null, params.get(key)));
            }
        }
        RequestBody multiBody=multiBuilder.build();
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new   Request.Builder().url(url).post(multiBody).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败的处理
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });

        return null;
    }
*/

}
