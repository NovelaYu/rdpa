package com.yzw.zska.util;

import org.junit.rules.TestWatcher;

public class ExtentUtils extends TestWatcher {

/*    private ExtentReports extent;


    public ExtentUtils(ExtentReports extent) {
        this.extent = extent;

    }

    *//**获取扩展日志**//*
    public ExtentTest getExtenTest(ExtentReports extent, String method, String description) {
        ExtentTest test = extent.startTest(method, "测试"+description);
        test.log(LogStatus.PASS,"开始测试");
        return test;
    }


    *//**关闭日志**//*
 *//*   public void flushReports(ExtentReports extent,ExtentTest test){
        test.log(Status.PASS,"测试完成");
        extent.endTest(test);
        extent.flush();
    }*//*

    *//**成功写入日志**//*
    public void succeed(ExtentReports extent, String method, String input, String output, String description) {
       // ExtentTest test = getExtenTest(extent,method,description);
        test.log(LogStatus.PASS, "传入参数:"+ input);
        test.log(LogStatus.PASS,"传出参数:" + output);
        flushReports(extent,test);
    }

    *//**失败写入日志**//*
    public void fail(ExtentReports extent, String method, String input, String output, String description) {
        ExtentTest test = getExtenTest(extent,method,description);
        test.log(LogStatus.FAIL, "传入参数:"+ input);
        test.log(LogStatus.FAIL,"传出参数:" + output);
        flushReports(extent,test);
        Assert.fail();
    }

    *//**写入错误日志**//*
    public void error(ExtentReports extent, String method, String input, String output, String description) {
        ExtentTest test = getExtenTest(extent,method,description);
        test.log(LogStatus.ERROR, "传入参数:"+ input);
        test.log(LogStatus.ERROR,"传出参数:" + output);
        flushReports(extent,test);
        Assert.fail();
    }*/
}
