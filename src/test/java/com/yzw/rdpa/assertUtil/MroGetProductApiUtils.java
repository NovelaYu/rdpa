package com.yzw.rdpa.assertUtil;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.service.HttpService;
import okhttp3.Response;
import org.junit.Assert;
import org.testng.Reporter;

import java.io.IOException;

public class MroGetProductApiUtils extends ReportUtil {

    String method="ProductCenterAPIService.MroService.GetProductSysNo";


    /**返回参数存在**/
    public void  assertExitResult(Object object,String url,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceJsonHttp(object.toString(),url);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            try {
                Assert.assertNotNull(jsonObject.get("jsonrpc"));
                Assert.assertNotNull(jsonObject.get("id"));
                Assert.assertNotNull(jsonObject.getString("result"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+e.toString()+jsonObject.toJSONString(),false);
                /**return 从当前方法退出，返回到该调用方法的语句处
                 * break 退出当前循环，退出 switch 语句
                 * **/
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonObject.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("返回参数："+e.toString(),false);
        } finally {
            Reporter.log("测试结束");
        }

    }

    /**返回参数不存在**/
    public void assertNullResult(Object object,String url,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceJsonHttp(object.toString(),url);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            try {
                Assert.assertNotNull(jsonObject.get("jsonrpc"));
                Assert.assertNotNull(jsonObject.get("id"));
                Assert.assertNull(jsonObject.getString("result"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+jsonObject.toJSONString(),true);
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonObject.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("返回参数："+e.toString(),false);
        } finally {
            Reporter.log("测试结束");
        }
    }

    /**返回异常信息**/
    public void assertErrorResult(Object object,String url,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceJsonHttp(object.toString(),url);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonError = jsonObject.getJSONObject("error");
            try {
                Assert.assertNotNull(jsonError.get("error"));
                Assert.assertNull(jsonError.get("message"));
                Assert.assertNotEquals("0000",jsonError.get("code"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+jsonObject.toJSONString(),true);
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonError.get("data"),true);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("返回参数："+e.toString(),false);
        } finally {
            Reporter.log("测试结束");
        }
    }
}
