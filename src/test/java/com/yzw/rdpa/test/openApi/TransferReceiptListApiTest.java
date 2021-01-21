package com.yzw.rdpa.test.openApi;


import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.TransferReceipt;
import com.yzw.rdpa.assertUtil.OpenApiUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes= RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
 **/
public class TransferReceiptListApiTest extends AbstractTestNGSpringContextTests {

    private String method = "RS.API.QueryRSTransferReceiptList";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**执行测试方法并断言**/
    private static OpenApiUtils openAPiUtils;

    @BeforeClass
    public static void beforeClass() {
        openAPiUtils = new OpenApiUtils();
    }

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        String description = "只传 projectList";
        TransferReceipt transferReceipt = new TransferReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        transferReceipt.setProjectSysNoList(list);


        openAPiUtils.assertExitResult(transferReceipt,method,className,description);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        TransferReceipt transferReceipt = new TransferReceipt();

        openAPiUtils.assertErrorResult(transferReceipt,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据*";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);

        openAPiUtils.assertExitResult(transferReceipt,method,className,description);
    }

    /**传入错误的调拨项目名称**/
    @Test
    public void testErrorFromProjectName(){
        String description = "传入错误的调拨项目名称";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setFromProjectName("1212");

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }

    /**传入错误的收料单位名称**/
    @Test
    public void testErrorToProjectName(){
        String description = "传入错误的收料单位名称";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setToProjectName("1212");

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setReceiptStatus(1212);

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }


    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setDataDateBegin("2022-12-23 18:00:00");

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setPageIndex(101);

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }

    /**传入错误的调拨单号**/
    @Test
    public void testErrorReturnCode(){
        String description = "传入错误的调拨单号";
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setCode("1212");

        openAPiUtils.assertNullResult(transferReceipt,method,className,description);

    }

}
