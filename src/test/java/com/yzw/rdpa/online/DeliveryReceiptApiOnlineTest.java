package com.yzw.rdpa.online;

import com.alibaba.fastjson.JSONObject;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import com.yzw.rdpa.BaseTest;
import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.entity.DeliveryReceipt;
import com.yzw.rdpa.service.HttpService;
import com.yzw.rdpa.util.ExtentUtils;
import okhttp3.Response;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
public class DeliveryReceiptApiOnlineTest  {

    private String method = "RS.API.QueryDeliveryReceiptList";

    private static ExtentReports extent;
    private static String object;

    @BeforeClass
    public static void beforeClass() {
        Thread thread = Thread.currentThread(); // 获取当前线程
        StackTraceElement[] trace = thread.getStackTrace(); // 获取当前线程的栈快照(入栈方法的数据)
        String methodName = trace[1].getClassName(); // 获取当前方法所在的类名
        String reportPath = "reports/"+methodName+".html";
        extent = new ExtentReports(reportPath, true, NetworkMode.OFFLINE);

    }

    @AfterClass
    public static void afterClass() {
        extent.close();
    }

    @Rule
    public ExtentUtils eu = new ExtentUtils(extent);

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        List<Object> details = new ArrayList<>();
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(24661);
        list.add(1);
        deliveryReceipt.setProjectSysNoList(list);

        /**打印日志**/
        details.add(deliveryReceipt);
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            System.out.println(deliveryReceipt.toString());
            System.out.println(jsonObject.toJSONString());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals("0",jsonObject.get("Code"));
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertNotNull(jsonData.getString("Rows"));
            /*details.add(jsonData);*/
            object +="测试" ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            //JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals("1001",jsonObject.get("Code"));
            Assert.assertEquals(false,jsonObject.get("Success"));
            // Assert.assertNotNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入完整的所有数据**/
    @Test
    public void testAllResut(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            System.out.println(jsonObject.toJSONString());
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertNotNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**传入错误的供应商**/
    @Test
    public void testErrorSupplierName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setSuplierName("1212");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的状态**/
    @Test
    public void testErrorStatus(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setStatus(121);
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的合同编码**/
    @Test
    public void testErrorContractCode(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setContractCode("12212");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的合同名称**/
    @Test
    public void testErrorContractName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setContractName("12121");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的订单编码**/
    @Test
    public void testErrorOrderCode(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setOrderCode("12121");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的订单名称**/
    @Test
    public void testErrorOrderName(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setOrderName("1212");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的来源**/
    @Test
    public void testErrorSource(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setSource(121);
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的开始时间**/
    @Test
    public void testErrorBeginTime(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setDataDateBegin("2022-12-23 18:00:00");
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**传入错误的页面数量**/
    @Test
    public void testErrorPageIndex(){
        DeliveryReceipt deliveryReceipt = DeliveryReceipt.getDeliveryReceipt(true);
        deliveryReceipt.setPageIndex(101);
        try {
            Response response = HttpService.exceHttp(deliveryReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            /**传入错误的参数结果返回为空**/
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertEquals("0",jsonData.getString("TotalCount"));
            Assert.assertNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
