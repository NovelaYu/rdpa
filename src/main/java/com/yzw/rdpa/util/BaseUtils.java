package com.yzw.rdpa.util;


import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.service.HttpService;
import okhttp3.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseUtils {

    private ExtentReports extent;

    public BaseUtils(ExtentReports extent) {
        this.extent = extent;
    }
    public ExtentTest getExtenTest(ExtentReports extent, String method) {
        ExtentTest test = extent.startTest(method, "测试");
        test.log(LogStatus.PASS,"开始测试");
        return test;
    }

    public ExtentTest getExtenTest01(String method) {
        ExtentTest test = extent.startTest(method, "测试");
        test.log(LogStatus.PASS,"开始测试");
        return test;
    }


    public void flushReports(ExtentReports extent,ExtentTest test){
        test.log(LogStatus.PASS,"测试完成");
        extent.endTest(test);
        extent.flush();
    }

    public void succeed(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(extent,method);
        test.log(LogStatus.PASS, "传入参数:"+ input);
        test.log(LogStatus.PASS,"传出参数:" + output);
        flushReports(extent,test);
    }

    public void fail(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(extent,method);
        test.log(LogStatus.FAIL, "传入参数:"+ input);
        test.log(LogStatus.FAIL,"传出参数:" + output);
        flushReports(extent,test);
    }

    public void error(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(extent,method);
        test.log(LogStatus.ERROR, "传入参数:"+ input);
        test.log(LogStatus.ERROR,"传出参数:" + output);
        flushReports(extent,test);
    }

    /**返回参数存在**/
    public void  assertExitResult(Object oboject,String method,String currentmethod) {
        try {
            Response response = HttpService.exceHttp(oboject,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            try {
                Assert.assertEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("Success"));
                Assert.assertNotNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**补货失败异常**/
                fail(extent,currentmethod,oboject.toString(),e.toString()+jsonObject.get("Message"));
                /**return 从当前方法退出，返回到该调用方法的语句处
                 * break 退出当前循环，退出 switch 语句
                 * **/
                return;
            }
            /**打印日志**/
            succeed(extent,currentmethod,oboject.toString(),jsonData.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            error(extent,currentmethod,oboject.toString(),e.toString());
        }
    }

    /**返回参数不存在**/
    public void assertNullResult(Object oboject,String method,String currentmethod) {
        try {
            Response response = HttpService.exceHttp(oboject,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            try {
                Assert.assertEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("Success"));
                Assert.assertNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**补货失败异常**/
                fail(extent,currentmethod,oboject.toString(),e.toString()+jsonObject.get("Message"));
                return;
            }
            /**打印日志**/
            succeed(extent,currentmethod,oboject.toString(),jsonData.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            error(extent,currentmethod,oboject.toString(),e.toString());
        }
    }

    /**返回异常信息**/
    public void assertErrorResult(Object oboject,String method,String currentmethod) {
        try {
            Response response = HttpService.exceHttp(oboject,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            //JSONObject jsonData = jsonObject.getJSONObject("Data");
            try {
                Assert.assertNotEquals("0",jsonObject.get("Code"));
                Assert.assertEquals(true,jsonObject.get("false"));
                //Assert.assertNull(jsonData.getString("Rows"));
            } catch (Throwable e) {
                /**补货失败异常**/
                fail(extent,currentmethod,oboject.toString(),e.toString()+jsonObject.get("Message"));
                return;
            }
            /**打印日志**/
            succeed(extent,currentmethod,oboject.toString(),jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
            error(extent,currentmethod,oboject.toString(),e.toString());
        }
    }

}
