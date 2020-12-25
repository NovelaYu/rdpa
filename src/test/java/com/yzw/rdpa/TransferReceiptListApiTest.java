package com.yzw.rdpa;

import com.alibaba.fastjson.JSONObject;
import com.yzw.rdpa.entity.ReturnStockReceipt;
import com.yzw.rdpa.entity.SendReceipt;
import com.yzw.rdpa.entity.TransferReceipt;
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
public class TransferReceiptListApiTest extends BaseTest {
    private String method = "RS.API.QueryRSTransferReceiptList";

    /**只传 projectList**/
    @Test
    public void testProjectList(){
        TransferReceipt transferReceipt = new TransferReceipt();
        List<Integer> list = new ArrayList<>();
        list.add(47369);
        list.add(1);
        transferReceipt.setProjectSysNoList(list);

        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
        TransferReceipt transferReceipt = new TransferReceipt();
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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

    /**传入错误的调拨项目名称**/
    @Test
    public void testErrorFromProjectName(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setFromProjectName("1212");
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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

    /**传入错误的收料单位名称**/
    @Test
    public void testErrorToProjectName(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setToProjectName("1212");
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setReceiptStatus(1212);
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setDataDateBegin("2022-12-23 18:00:00");
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setPageIndex(101);
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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

    /**传入错误的调拨单号**/
    @Test
    public void testErrorReturnCode(){
        TransferReceipt transferReceipt = TransferReceipt.getTransferReceipt(false);
        transferReceipt.setCode("1212");
        try {
            Response response = HttpService.exceHttp(transferReceipt,method);
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
