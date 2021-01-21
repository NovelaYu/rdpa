package com.yzw.rdpa.online.openApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.SendReceipt;
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
public class SendReceiptInfoListApiOnlineTest extends AbstractTestNGSpringContextTests {

    private String method = "RS.API.QueryRSSendReceiptInfoList";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**生成测试报告**/
    //private static ExtentReports extent;
    private static OpenApiUtils baseUtils;

    @BeforeClass
    public static void beforeClass() {
        baseUtils = new OpenApiUtils();
    }

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        String description = "只传 projectList";
        SendReceipt sendReceipt = new SendReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        sendReceipt.setProjectSysNoList(list);


        baseUtils.assertNullResult(sendReceipt,method,className,description);


    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        SendReceipt sendReceipt = new SendReceipt();

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);

        baseUtils.assertNullResult(sendReceipt,method,className,description);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        String description = "传入错误的供应商";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setSupplierName("1212");

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setStatus(121);

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }


    /**传入错误的收料模式**/
    @Test
    public void testErrorMode(){
        String description = "传入错误的收料模式";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setReceiptMode(11);

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setDataDateBegin("2022-12-23 18:00:00");

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setPageIndex(101);

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }

    /**传入错误的发货单号**/
    @Test
    public void testErrorReceiveReceiptCode(){
        String description = "传入错误的发货单号";
        SendReceipt sendReceipt = SendReceipt.getSendReceipt(true);
        sendReceipt.setReceiptCode("1212");

        baseUtils.assertNullResult(sendReceipt,method,className,description);

    }



}
