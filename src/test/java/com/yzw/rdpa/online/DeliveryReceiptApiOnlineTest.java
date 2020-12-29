package com.yzw.rdpa.online;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.DeliveryReceipt;

import com.yzw.rdpa.util.BaseUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
public class DeliveryReceiptApiOnlineTest {


    private String method = "RS.API.QueryDeliveryReceiptList";

    /**生成测试报告**/
    private static ExtentReports extent;
    private static BaseUtils baseUtils;

    @BeforeClass
    public static void beforeClass() {
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String reportPath = "reports/"+className+".html";
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
        baseUtils = new BaseUtils(extent);
        //System.out.println("子类后执行");
    }

    @AfterClass
    public static void afterClass() {
        extent.close();
    }

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        deliveryReceipt.setProjectSysNoList(list);

        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertExitResult(deliveryReceipt,method,currentmethod);

    }

    /**必填参数不传校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertErrorResult(deliveryReceipt,method,currentmethod);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResult(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertExitResult(deliveryReceipt,method,currentmethod);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setSuplierName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setStatus(121);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的合同编码**/
    @Test
    public void testErrorContractCode(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setContractCode("12212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的合同名称**/
    @Test
    public void testErrorContractName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setContractName("12121");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的订单编码**/
    @Test
    public void testErrorOrderCode(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setOrderCode("12121");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);
    }

    /**传入错误的订单名称**/
    @Test
    public void testErrorOrderName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setOrderName("1212");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的来源**/
    @Test
    public void testErrorSource(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setSource(121);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setDataDateBegin("2022-12-23 18:00:00");
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setPageIndex(101);
        String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        baseUtils.assertNullResult(deliveryReceipt,method,currentmethod);

    }



}
