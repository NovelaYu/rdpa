package com.yzw.rdpa.test;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.ReturnStockReceipt;
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
public class ReturnStockReceiptApiTest {

    private String method = "RS.API.QueryRSReturnStockReceiptList";

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
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        ReturnStockReceipt.setProjectSysNoList(list);

        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(ReturnStockReceipt,method,currentmethod);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(ReturnStockReceipt,method,currentmethod);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);
    }

    /**传入错误的项目名称**/
    @Test
    public void testErrorProjectName(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        returnStockReceipt.setProjectName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        returnStockReceipt.setReceiptStatus(1212);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);


    }


    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        returnStockReceipt.setDataDateBegin("2022-12-23 18:00:00");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);


    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        returnStockReceipt.setPageIndex(101);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);


    }

    /**传入错误的退库单号**/
    @Test
    public void testErrorReturnCode(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(true);
        returnStockReceipt.setCode("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(returnStockReceipt,method,currentmethod);

    }

}
