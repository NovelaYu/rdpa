package com.yzw.rdpa.online.openApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.ReceiveReceipt;
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
public class ReceiveReceiptInfoApiOnlineTest extends AbstractTestNGSpringContextTests {

    private String method = "RS.API.QueryRSReceiveReceiptInfoList";
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
        ReceiveReceipt receiveReceipt = new ReceiveReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        receiveReceipt.setProjectSysNoList(list);

        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        ReceiveReceipt receiveReceipt = new ReceiveReceipt();
        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);

        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        String description = "传入错误的供应商";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setSupplierName("1212");
        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setStatus(121);
        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);
    }

    /**传入错误的合同编码**/
    @Test
    public void testErrorContractCode(){
        String description = "传入错误的合同编码";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setContractCode("12212");
        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的合同名称**/
    @Test
    public void testErrorContractName(){
        String description = "传入错误的合同名称";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setContractName("12121");
        ////String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的订单编码**/
    @Test
    public void testErrorOrderCode(){
        String description = "传入错误的订单编码";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setOrderCode("12121");
        // //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的订单名称**/
    @Test
    public void testErrorOrderName(){
        String description = "传入错误的订单名称*";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setOrderName("1212");
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的收料模式**/
    @Test
    public void testErrorMode(){
        String description = "传入错误的收料模式";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setReceiptMode(11);
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setDataDateBegin("2022-12-23 18:00:00");
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setPageIndex(101);
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }

    /**传入错误的收料单号**/
    @Test
    public void testErrorReceiveReceiptCode(){
        String description = "传入错误的收料单号";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setReceiveReceiptCode("1212");
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);
    }

    /**传入错误的发货单号**/
    @Test
    public void testErrorDeliveryReceiptCode(){
        String description = "传入错误的发货单号";
        ReceiveReceipt receiveReceipt = ReceiveReceipt.getReceiveReceipt(false);
        receiveReceipt.setReceiveReceiptCode("1212");
        //String className = Thread.currentThread().getStackTrace()[1].getMethodName());
        openAPiUtils.assertNullResult(receiveReceipt,method,className,description);

    }



}

