package com.yzw.rdpa;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.entity.RSPickInfo;
import com.yzw.rdpa.entity.ReceiveReceipt;
import com.yzw.rdpa.entity.ReturnStockReceipt;
import com.yzw.rdpa.service.HttpService;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RdpaApplication.class)
public class ReturnStockReceiptApiTest extends BaseTest{

    private String method = "RS.API.QueryRSReturnStockReceiptList";

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        ReturnStockReceipt.setProjectSysNoList(list);

        try {
            Response response = HttpService.exceHttp(ReturnStockReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals("0",jsonObject.get("Code"));
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertNotNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**必填参数不穿校验，不传 projectList**/
    @Test
    public void testNOProjectList(){
        ReturnStockReceipt ReturnStockReceipt = new ReturnStockReceipt();
        try {
            Response response = HttpService.exceHttp(ReturnStockReceipt,method);
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
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
            /** response.body().string() 只能使用一次，再次调用就会关闭 **/
            //System.out.println(response.body().string());
            JSONObject jsonObject = JSONObject.parseObject(response.body().string());
            JSONObject jsonData = jsonObject.getJSONObject("Data");
            Assert.assertEquals(true,jsonObject.get("Success"));
            Assert.assertNotNull(jsonData.getString("Rows"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**传入错误的项目名称**/
    @Test
    public void testErrorProjectName(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setProjectName("1212");
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
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
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setReceiptStatus(1212);
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
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
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setDataDateBegin("2022-12-23 18:00:00");
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
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
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setPageIndex(101);
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
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

    /**传入错误的退库单号**/
    @Test
    public void testErrorReturnCode(){
        ReturnStockReceipt returnStockReceipt = ReturnStockReceipt.getReturnStockReceipt(false);
        returnStockReceipt.setCode("1212");
        try {
            Response response = HttpService.exceHttp(returnStockReceipt,method);
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
