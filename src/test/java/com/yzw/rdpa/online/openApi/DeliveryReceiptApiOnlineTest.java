package com.yzw.rdpa.online.openApi;


import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.DeliveryReceipt;

import com.yzw.rdpa.assertUtil.OpenApiUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
**/

public class DeliveryReceiptApiOnlineTest extends AbstractTestNGSpringContextTests {


    private String method = "RS.API.QueryDeliveryReceiptList";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();

    /**生成测试报告**/
   // private static ExtentReports extent;
    private static OpenApiUtils openAPiUtils;

    @BeforeClass
    public static void beforeClass() {
        openAPiUtils = new OpenApiUtils();
    }


    /**只传 projectList**/
    @Test
    public void testProjectList(){
        String description = "只传 projectList";
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        deliveryReceipt.setProjectSysNoList(list);
        openAPiUtils.assertExitResult(deliveryReceipt,method,className,description);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        openAPiUtils.assertErrorResult(deliveryReceipt,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertExitResult(deliveryReceipt,method,className,description);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        String description = "传入错误的供应商";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertExitResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setStatus(121);
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的合同编码**/
    @Test
    public void testErrorContractCode(){
        String description = "传入错误的合同编码";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setContractCode("12212");
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的合同名称**/
    @Test
    public void testErrorContractName(){
        String description = "传入错误的合同名称";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setContractName("12121");
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的订单编码**/
    @Test
    public void testErrorOrderCode(){
        String description = "传入错误的订单编码";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setOrderCode("12121");
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);
    }

    /**传入错误的订单名称**/
    @Test
    public void testErrorOrderName(){
        String description = "传入错误的订单名称";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setOrderName("1212");
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的来源**/
    @Test
    public void testErrorSource(){
        String description = "传入错误的来源";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setSource(121);
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setDataDateBegin("2022-12-23 18:00:00");
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(false);
        deliveryReceipt.setPageIndex(101);
        //String currentmethod = Thread.currentThread().getStackTrace()[1].getMethodName();
        openAPiUtils.assertNullResult(deliveryReceipt,method,className,description);

    }



}
