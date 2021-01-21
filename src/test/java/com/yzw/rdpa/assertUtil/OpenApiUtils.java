package com.yzw.rdpa.assertUtil;
import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.service.HttpService;
import com.yzw.rdpa.util.ReportsUtil;
import okhttp3.Response;
import org.junit.Assert;

import java.io.IOException;


/**针对openAPi进行的封装**/
public class OpenApiUtils extends ReportUtil {
    /**预发环境url**/
    /*String url = "https://api.jc.yzw.cn:8081/open.api";*/
    /**正式环境**/
    //String url = "https://api.jc.yzw.cn:8081/open.api";
    /**测试环境**/
    String url = "http://api.jc.yzw.cn.qa:8008/open.api";

    /**返回参数存在**/
    public void  assertExitResult(Object object,String method,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceHttp(url,object,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");

            try {
                Assert.assertEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("Success"));
                Assert.assertNotNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**捕获失败异常**/
                ReportsUtil.log("返回参数："+e.toString()+jsonObject.get("Message"),false);
                Assert.fail();
                /**return 从当前方法退出，返回到该调用方法的语句处
                 * break 退出当前循环，退出 switch 语句
                 * **/
                return;
            }
            /**打印日志**/
            ReportsUtil.log("返回参数："+jsonData.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            ReportsUtil.log("返回参数："+e.toString(),false);
            Assert.fail();
        } finally {
            ReportsUtil.log("测试结束");
        }
    }

    /**返回参数不存在**/
    public void assertNullResult(Object object,String method,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceHttp(url,object,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            try {
                Assert.assertEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("Success"));
                Assert.assertNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**捕获失败异常**/
                ReportsUtil.log("返回参数："+e.toString()+jsonObject.get("Message"),false);
                Assert.fail();
                /**return 从当前方法退出，返回到该调用方法的语句处
                 * break 退出当前循环，退出 switch 语句
                 * **/
                return;
            }
            /**打印日志**/
            ReportsUtil.log("返回参数："+jsonData.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            //error(extent,currentmethod,oboject.toString(),e.toString(),description);
            ReportsUtil.log("返回参数："+e.toString(),false);
            Assert.fail();
        } finally {
            ReportsUtil.log("测试结束");
        }
    }

    /**返回异常信息**/
    public void assertErrorResult(Object object,String method,String className,String description) {
        reports(object,url,className,description,method);
        try {
            Response response = HttpService.exceHttp(url,object,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            try {
                Assert.assertNotEquals("0",jsonObject.get("Code"));
                Assert.assertNotEquals(true,jsonObject.get("Success"));
            } catch (Throwable e) {
                /**捕获失败异常**/
                ReportsUtil.log("返回参数："+e.toString()+jsonObject.get("Message"),false);
                Assert.fail();
                return;
            }
            /**打印日志**/
            ReportsUtil.log("返回参数："+jsonObject.toJSONString(),true);
        } catch (IOException e) {
            e.printStackTrace();
            ReportsUtil.log("返回参数："+e.toString(),false);
            Assert.fail();
        } finally {
            ReportsUtil .log("测试结束");
        }
    }

}
