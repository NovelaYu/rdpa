package com.yzw.rdpa.assertUtil;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.service.HttpService;
import okhttp3.Response;
import org.junit.Assert;
import org.testng.Reporter;

import java.io.IOException;

/**mro接口断言**/
public class MroUpdateCategoryApiUtils extends ReportUtil {

    String method="ProductCenterAPIService.MroService.CreateUpdateCategory";

    /**返回参数存在**/
    public void  assertExitResult(Object object,String url,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceJsonHttp(object.toString(),url);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            try {
                Assert.assertNull(jsonObject.getString("error"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+e.toString()+jsonObject.get("Message"),false);
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
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            try {
                Assert.assertEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("Success"));
                Assert.assertNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**补货失败异常**/
                Reporter.log("返回参数："+jsonObject.toJSONString(),true);
                return;
            }
            /**打印日志**/
            Reporter.log("返回参数："+jsonObject.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            //error(extent,currentmethod,oboject.toString(),e.toString(),description);
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
            Reporter.log("用例描述："+description);
            try {
                Assert.assertNotEquals("0000",jsonObject.get("code"));
                Assert.assertNotNull(jsonObject.getString("error"));
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


}
