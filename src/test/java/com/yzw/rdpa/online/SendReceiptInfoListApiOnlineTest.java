package com.yzw.rdpa.online;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.ReceiveReceipt;
import com.yzw.rdpa.entity.SendReceipt;
import com.yzw.rdpa.service.HttpService;
import com.yzw.rdpa.util.BaseUtils;
import com.yzw.rdpa.util.ExtentUtils;
import okhttp3.Response;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
public class SendReceiptInfoListApiOnlineTest {

    private String method = "RS.API.QueryRSSendReceiptInfoList";

    /**生成测试报告**/
    private static ExtentReports extent;
    private static BaseUtils baseUtils;

    @BeforeClass
    public static void beforeClass() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String reportPath = "reports/"+className+".html";
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
        SendReceipt sendReceipt = new SendReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        sendReceipt.setProjectSysNoList(list);

        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);


    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        SendReceipt sendReceipt = new SendReceipt();
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertErrorResult(sendReceipt,method,currentmethod);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResult(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertExitResult(sendReceipt,method,currentmethod);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setSupplierName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setStatus(121);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }






    /**传入错误的收料模式**/
    @Test
    public void testErrorMode(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setReceiptMode(11);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setDataDateBegin("2022-12-23 18:00:00");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setPageIndex(101);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }

    /**传入错误的发货单号**/
    @Test
    public void testErrorReceiveReceiptCode(){
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setReceiptCode("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(sendReceipt,method,currentmethod);

    }



}
