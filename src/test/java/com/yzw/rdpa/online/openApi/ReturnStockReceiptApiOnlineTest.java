package com.yzw.rdpa.online.openApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.ReturnStockReceipt;
import com.yzw.rdpa.assertUtil.OpenApiUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
 **/
public class ReturnStockReceiptApiOnlineTest extends AbstractTestNGSpringContextTests {

    private String method = "RS.API.QueryRSReturnStockReceiptList";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**生成测试报告**/
    //private static ExtentReports extent;
    private static OpenApiUtils openAPiUtils;

    @BeforeClass
    public static void beforeClass() {
        openAPiUtils = new OpenApiUtils();
    }


    /**只传 projectList**/
    @Test
    public void testProjectList(){
        String description = "只传 projectList";
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        ReturnStockReceipt.setProjectSysNoList(list);


        openAPiUtils.assertNullResult(ReturnStockReceipt,method,className,description);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();

        openAPiUtils.assertNullResult(ReturnStockReceipt,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);
    }

    /**传入错误的项目名称**/
    @Test
    public void testErrorProjectName(){
        String description = "传入错误的项目名称";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setProjectName("1212");

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setReceiptStatus(1212);

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);


    }


    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setDataDateBegin("2022-12-23 18:00:00");

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);


    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setPageIndex(101);

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);


    }

    /**传入错误的退库单号**/
    @Test
    public void testErrorReturnCode(){
        String description = "传入错误的退库单号";
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setCode("1212");

        openAPiUtils.assertNullResult(returnStockReceipt,method,className,description);

    }


}
