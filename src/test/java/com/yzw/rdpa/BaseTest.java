package com.yzw.rdpa;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.util.ExtentUtils;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
public  class BaseTest {
   /* private static ExtentReports extent;

    @BeforeClass
    public static void beforeClass() {
        //String methodName = getString();
       // String reportPath = "reports/"+methodName+".html";
        //extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
    }


    @AfterClass
    public static void afterClass() {
        extent.close();
    }

    @Rule
    public ExtentUtils eu = new ExtentUtils(extent,object);*/


}
