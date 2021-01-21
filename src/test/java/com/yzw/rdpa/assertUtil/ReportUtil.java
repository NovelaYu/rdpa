package com.yzw.rdpa.assertUtil;

import org.testng.Reporter;

public class ReportUtil {

    public void reports(Object object, String url, String className, String description, String method) {
        Reporter.log("当前接口名称：" + url);
        Reporter.log("当前方法名称: " + method);
        Reporter.log("当前类路径：" + className);
        Reporter.log("用例描述："+description);
        Reporter.log("获取到参数："+object,false);
    }
}
