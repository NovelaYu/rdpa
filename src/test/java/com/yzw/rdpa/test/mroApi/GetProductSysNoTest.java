package com.yzw.rdpa.test.mroApi;

import com.yzw.rdpa.assertUtil.MroGetProductApiUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetProductSysNoTest {

    private String url = "http://service.productcenter.yzw.cn.qa:8002/json.rpc";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**生成测试报告**/
    private static MroGetProductApiUtils mroGetProductApiUtils;

    @BeforeClass
    public static void beforeClass() {
        mroGetProductApiUtils = new MroGetProductApiUtils();
    }


    @Test
    public void testErrorProductId() {
        String description = "传入商品编码为字符串 ssd，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.GetProductSysNo\",\n" +
                "    \"params\": {\n" +
                "        \"productId\":sdsd\n" +
                "\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroGetProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testExitProductId() {
        String description = "传入商品编码为 1，期望返回结果正确且有值";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.GetProductSysNo\",\n" +
                "    \"params\": {\n" +
                "        \"productId\":1\n" +
                "\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroGetProductApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testNotExitProductId() {
        String description = "传入商品编码为 12000001，期望返回结果为空";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.GetProductSysNo\",\n" +
                "    \"params\": {\n" +
                "        \"productId\":1200001\n" +
                "\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroGetProductApiUtils.assertNullResult(json,url,className,description);
    }

    @Test
    public void testProductIdIsNegative() {
        String description = "传入商品编码为负数 -1，期望返回结果为空";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.GetProductSysNo\",\n" +
                "    \"params\": {\n" +
                "        \"productId\":-1 \n" +
                "\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroGetProductApiUtils.assertNullResult(json,url,className,description);
    }


    @Test
    public void testFirtZeroProductId() {
        String description = "传入商品编码以0开头 0001，自动转换为1，期望返回结果有值且正确";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.GetProductSysNo\",\n" +
                "    \"params\": {\n" +
                "        \"productId\":0001 \n" +
                "\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroGetProductApiUtils.assertExitResult(json,url,className,description);
    }

}
