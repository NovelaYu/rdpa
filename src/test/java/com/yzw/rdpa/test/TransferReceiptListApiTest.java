package com.yzw.rdpa.test;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.TransferReceipt;
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
public class TransferReceiptListApiTest {
    private String method = "RS.API.QueryRSTransferReceiptList";

    /**生成测试报告**/
    private static ExtentReports extent;
    /**执行测试方法并断言**/
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
        TransferReceipt transferReceipt = new TransferReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        transferReceipt.setProjectSysNoList(list);

        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        TransferReceipt transferReceipt = new TransferReceipt();
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);
    }

    /**传入错误的调拨项目名称**/
    @Test
    public void testErrorFromProjectName(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setFromProjectName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**传入错误的收料单位名称**/
    @Test
    public void testErrorToProjectName(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setToProjectName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setReceiptStatus(1212);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }


    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setDataDateBegin("2022-12-23 18:00:00");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setPageIndex(101);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

    /**传入错误的调拨单号**/
    @Test
    public void testErrorReturnCode(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(true);
        transferReceipt.setCode("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(transferReceipt,method,currentmethod);

    }

}
