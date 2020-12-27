package com.yzw.rdpa.test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.util.BaseUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= RdpaApplication.class)
public class ReportTest01 {

    private static ExtentReports extent;

    /**生成测试报告**/

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
        List<Object> details = new ArrayList<>();
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        deliveryReceipt.setProjectSysNoList(list);
        /**打印日志**/

        /**输出测试报告**/
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        //succeed(extent,method,deliveryReceipt.toString(),"success");

    }

    @Test
    public void testProjectList01(){
        List<Object> details = new ArrayList<>();
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        deliveryReceipt.setProjectSysNoList(list);
        /**打印日志**/

        /**输出测试报告**/
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        //ExtentTest test = getExtenTest(extent,method);
        ///test.log(LogStatus.PASS, "传入参数01:"+deliveryReceipt.toString());
        //test.log(LogStatus.PASS,"传出参数01:");
        //flushReports(extent,test);

    }
}
