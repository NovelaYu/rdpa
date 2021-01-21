package com.yzw.rdpa.assertUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.service.HttpService;
import okhttp3.Response;
import org.junit.Assert;
import org.testng.Reporter;

import java.io.IOException;

/**新增商品接口断言响应**/
public class MroUpdateProductApiUtils extends ReportUtil {

    String method="ProductCenterAPIService.MroService.CreateUpdateProducts";


    /**返回参数存在**/
    public void  assertExitResult(Object object,String url,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceJsonHttp(object.toString(),url);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            /**JsonArry转jsonObject**/
            JSONObject jsonResult =  jsonObject.getJSONArray("result").getJSONObject(0);
            try {
                Assert.assertNull(jsonResult.getString("ErrorMsg"));
                Assert.assertEquals("true",jsonResult.getString("Success"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+e.toString()+jsonResult.get("ErrorMsg"),false);
                /**return 从当前方法退出，返回到该调用方法的语句处
                 * break 退出当前循环，退出 switch 语句
                 * **/
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonResult.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            Reporter.log("获取到参数："+object.toString(),false);
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
            JSONObject jsonResult =  jsonObject.getJSONArray("result").getJSONObject(0);
            try {
                Assert.assertNotNull(jsonResult.get("ErrorMsg"));
                Assert.assertNull(jsonResult.get("Mapping"));
                Assert.assertEquals("false",jsonResult.get("Success"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+jsonResult.toJSONString(),true);
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonResult.toJSONString(),true);
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
                Assert.assertNull(jsonError.get("Mapping"));
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
