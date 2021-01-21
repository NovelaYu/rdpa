package com.yzw.rdpa.test;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.assertUtil.OpenApiUtils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= RdpaApplication.class)
public class ReportTest01 extends AbstractTestNGSpringContextTests {

    //private static ExtentReports extent;

    /**生成测试报告**/

    private static OpenApiUtils openAPiUtils;

    @BeforeClass
    public static void beforeClass() {
        openAPiUtils = new OpenApiUtils();
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
