package com.yzw.rdpa.test.openApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.RSPickInfo;
import com.yzw.rdpa.assertUtil.OpenApiUtils;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
 **/
public class PickInfoListApiTest extends AbstractTestNGSpringContextTests {

    private String method = "RS.API.QueryRSPickInfoList";
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
        RSPickInfo rsPickInfo = new RSPickInfo();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        rsPickInfo.setProjectSysNoList(list);

        openAPiUtils.assertExitResult(rsPickInfo,method,className,description);

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        String description = "必填参数不穿校验，不传 projectList";
        RSPickInfo rsPickInfo = new RSPickInfo();

        openAPiUtils.assertErrorResult(rsPickInfo,method,className,description);

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        String description = "传入完整的所有数据";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);

        openAPiUtils.assertExitResult(rsPickInfo,method,className,description);
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorInUserName(){
        String description = "传入错误的供应商";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setInUserName("1212");

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        String description = "传入错误的状态";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setReceiptStatus(1212);

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }


    /**传入错误的领料单位**/
    @Test
    public void testPickDeptName(){
        String description = "传入错误的领料单位";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setPickDeptName("12121");

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        String description = "传入错误的开始时间";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setDataDateBegin("2022-12-23 18:00:00");

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        String description = "传入错误的页面数量";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setPageIndex(101);

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }

    /**传入错误的领料单号**/
    @Test
    public void testErrorPickCode(){
        String description = "传入错误的领料单号";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setCode("1212");

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }

    /**传入错误的分部工程**/
    @Test
    public void testErrorBuildingPartName(){
        String description = "传入错误的分部工程";
        RSPickInfo rsPickInfo = RSPickInfo.getRSPickInfo(false);
        rsPickInfo.setBuildingPartName("1212");

        openAPiUtils.assertNullResult(rsPickInfo,method,className,description);

    }


}
