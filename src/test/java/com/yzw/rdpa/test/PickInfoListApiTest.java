package com.yzw.rdpa.test;

import com.alibaba.fastjson.JSONObject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.RSPickInfo;
import com.yzw.rdpa.service.HttpService;
import com.yzw.rdpa.util.BaseUtils;
import okhttp3.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= RdpaApplication.class)
public class PickInfoListApiTest{
    private String method = "RS.API.QueryRSPickInfoList";

    /**生成测试报告**/
    private static ExtentReports extent;
    private static BaseUtils baseUtils;

    @BeforeClass
    public static void beforeClass() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String reportPath = "target/reports/"+className+".html";
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
        baseUtils = new BaseUtils(extent);
        System.out.println("子类后执行");
    }

    @AfterClass
    public static void afterClass() {
        extent.close();
    }

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        RSPickInfo rsPickInfo = new RSPickInfo();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        rsPickInfo.setProjectSysNoList(list);

        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        RSPickInfo rsPickInfo = new RSPickInfo();
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorInUserName(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setInUserName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setReceiptStatus(1212);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }


    /**传入错误的领料单位**/
    @Test
    public void testPickDeptName(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setPickDeptName("12121");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setDataDateBegin("2022-12-23 18:00:00");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setPageIndex(101);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入错误的领料单号**/
    @Test
    public void testErrorPickCode(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setCode("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }

    /**传入错误的分部工程**/
    @Test
    public void testErrorBuildingPartName(){
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(true);
        rsPickInfo.setBuildingPartName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(rsPickInfo,method,currentmethod);

    }


}
