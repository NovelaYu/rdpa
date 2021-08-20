package com.yzw.zska.test.sprint9.systemServer;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.zska.RdpaApplication;
import com.yzw.zska.entity.Login;
import com.yzw.zska.service.HttpService;
import com.yzw.zska.util.BaseUtils;
import com.yzw.zska.util.DateUtil;
import com.yzw.zska.util.ReportsUtil;
import okhttp3.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest(classes= RdpaApplication.class)
@Description("分页查询废弃制度")
public class RegulationGetCancelListByPageTest {
    /**生成测试报告**/
    private static ExtentReports extent;
    //private static ExtentTest test;
    private static BaseUtils baseUtils;
    private static String token;
    private String url ="https://kongfuzi.longfor.uat/admin-server/v1/rest/regulation/getCancelListByPage";

    @BeforeClass
    public static void beforeClass() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String reportPath = "target/reports/"+className+".html";
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
        baseUtils = new BaseUtils(extent);
        Login login = new Login("maoyxiang","jsidkjfk.@12");
        token = login.getCookie();
        //test = extent.startTest("开始测试");
        //todo
        /**token 为null, 不需要向下执行了，return没能阻止**/
        if (token == null ) {
            ReportsUtil.log("获取token失败");
            return;
        }

    }

    @AfterClass
    public static void afterClass() {
        extent.close();
    }


    @Test
    @Description("航道正常传值 C1，返回正确结果")
    public void testProjectList() {
        String json = "{\"pageNumber\":1,\"pageSize\":20}";

        HashMap<String,String> headersMap = new HashMap<>();
        headersMap.put("Cookie",token);
        ExtentTest test = extent.startTest("启动测试");
        try {
            Response response = HttpService.exceJsonHttp(json,headersMap,url);
            if (response.isSuccessful()) {
                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
                Assert.assertEquals("200",jsonObject.get("code"));
                Assert.assertEquals("ok",jsonObject.get("message"));
                Assert.assertNotNull(jsonObject.getString("data"));
                test.log(LogStatus.PASS,"开始测试");
                test.log(LogStatus.PASS,"测试完成");
                extent.endTest(test);
                extent.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            test.log(LogStatus.FAIL,e.getMessage());
            extent.endTest(test);
            extent.flush();
        }  finally {
            /**将调用当前接口的结束时间记录到报告**/
            ReportsUtil.log("http接口调用结束: " + DateUtil.getCurrentMilliSeconds());
        }

    }

    @Test
    @Description("异常值判断,不传值")
    public void testNoProjectList() {

        HashMap<String,String> headersMap = new HashMap<>();
        headersMap.put("Cookie",token);
        ExtentTest test = extent.startTest("启动测试");
        try {
            Response response = HttpService.getHttp(null,headersMap,url);
            if (response.isSuccessful()) {
                JSONObject jsonObject = JSONObject.parseObject(response.body().string());
                Assert.assertNotEquals("200",jsonObject.get("code"));
                test.log(LogStatus.PASS,"开始测试");
                test.log(LogStatus.PASS,"测试完成");
                extent.endTest(test);
                extent.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
            test.log(LogStatus.FAIL,e.getMessage());
            extent.endTest(test);
            extent.flush();
        }  finally {
            /**将调用当前接口的结束时间记录到报告**/
            ReportsUtil.log("http接口调用结束: " + DateUtil.getCurrentMilliSeconds());
        }

    }

}
