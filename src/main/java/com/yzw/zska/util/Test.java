package com.yzw.zska.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class Test {

    private ExtentReports extent;

    public ExtentTest getExtenTest(String method) {
        String reportPath = "reports/demo/extent.html";
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);
        //this.extent = extent;
        ExtentTest test = extent.startTest(method, "测试");
        test.log(LogStatus.PASS,"开始测试");
        return test;
    }


    public void flushReports(ExtentReports extent,ExtentTest test){
        test.log(LogStatus.PASS,"测试完成");
        extent.endTest(test);
        extent.flush();
    }

    public void succeed(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(method);
        test.log(LogStatus.PASS, "传入参数:"+ input);
        test.log(LogStatus.PASS,"传出参数:" + output);
        flushReports(extent,test);
    }

    public void fail(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(method);
        test.log(LogStatus.FAIL, "传入参数:"+ input);
        test.log(LogStatus.FAIL,"传出参数:" + output);
        flushReports(extent,test);
    }

    public void error(ExtentReports extent, String method,String input,String output) {
        ExtentTest test = getExtenTest(method);
        test.log(LogStatus.ERROR, "传入参数:"+ input);
        test.log(LogStatus.ERROR,"传出参数:" + output);
        flushReports(extent,test);
    }



}

