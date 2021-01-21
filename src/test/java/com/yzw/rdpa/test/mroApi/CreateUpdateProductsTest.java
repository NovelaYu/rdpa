package com.yzw.rdpa.test.mroApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.assertUtil.MroUpdateProductApiUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@SpringBootTest(classes= RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
 **/
public class CreateUpdateProductsTest extends AbstractTestNGSpringContextTests {

    private String url = "http://service.productcenter.yzw.cn.qa:8002/json.rpc";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**生成测试报告**/
    private static MroUpdateProductApiUtils mroUpdateProductApiUtils;

    @BeforeClass
    public static void beforeClass() {
        mroUpdateProductApiUtils = new MroUpdateProductApiUtils();
    }

    @Test
    public void testNomalParams() {
        String description = "传入正常的参数(categoryId，910010101)，期望：自动转成整数1,返回结果正常";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testFirstZeroCategory() {
        String description = "传入异常的参数(categoryId 以0开头，000910010101)，期望：不能自动转成整数,返回结果异常";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 000910010101,\n" +
                "                \"ProductCommonId\": 0091001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdInt() {
        String description = "传入分类编码id(CategoryId:sdsd)为字符串，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": \"sdsd\"s,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdNegative() {
        String description = "传入分类编码id为负数(CategoryId:-1)，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": -1,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdEmpty() {
        String description = "传入分类编码id为空字符串(CategoryId:'')，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": \" \",\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdNull() {
        String description = "传入分类编码id为Null(CategoryId:null)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": null,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductCommonIdInt() {
        String description = "传入spu_id(ProductCommonId:sssd)为字符串，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": \"sssd\",\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductCommonIdNegative() {
        String description = "传入spu_id为负数(ProductCommonId:-1)，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": -1,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductCommonIdEmpty() {
        String description = "传入spu_id为空字符串(ProductCommonId:'')，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": \" \",\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductCommonIdNull() {
        String description = "传入spu_id为Null(ProductCommonId:null)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": null,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testErrorCommonStatus() {
        String description = "传入状态值的参数(CommonStatus不在枚举范围，20)，期望，返回结果更新不成功";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 20\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertNullResult(json,url,className,description);
    }

    @Test
    public void testCommonStatusEmpty() {
        String description = "传入状态值为空字符串(CommonStatus:'')，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": \" \"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCommonStatusNull() {
        String description = "传入状态值为Null(CommonStatus:null)，期望返回结果报错";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":2,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": null \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductIdEmpty() {
        String description = "传入ProductId为空字符串(ProductId:'')，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":\" \",\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductIdNull() {
        String description = "传入ProductId为Null(ProductId:null)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":null,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductIdIsNegative() {
        String description = "传入ProductId为负数(ProductId:-1)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":-1 ,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testProductIdIsZero() {
        String description = "传入ProductId为0(ProductId:0)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":0 ,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertNullResult(json,url,className,description);
    }

    @Test
    public void testProductCommonIdIsZero() {
        String description = "传入ProductCommonId为0(ProductId:0)，期望通过";
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 0,\n" +
                "                \"ProductId\":1 ,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }


    @Test
    public void testProductNameEmpty() {
        String description = "传入分类编码名称为空字符串(ProductName:'')，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":1 ,\n" +
                "                \"ProductName\": \"\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertNullResult(json,url,className,description);
    }

    @Test
    public void testProductNameNull() {
        String description = "传入分类编码名称为Null(ProductName:null)，期望返回结果报错";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":1 ,\n" +
                "                \"ProductName\": null,\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testUpdateTimeAndStatus() {
        String description = "更新 categoryId 为1数据，CommonStatus 改为0，期望 状态时间都做更新";

        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\":1 ,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 0 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testInsertproductId() {
        String description = "取当前时间戳作为productId，插入新的cproductId,期望更新成功";
        int productId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 0,\n" +
                "                \"ProductId\": "+ productId + ",\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }

    /**同一级类名不能重复
     * 第一级分类不能重复
     * **/
    @Test
    public void testFirstSameProductName() {
        String description = "spu!=0 && sku不存在 && spu存在 ，期望成功";

        int productId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\": "+ productId + ",\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }


    /**1、spu传入值不为0且在映射表不存在
     2、sku不存在在映射表中不存在
     3、BrandName+三级分类 不存在
     * **/
    @Test
    public void testSkuNotExitAndSpuNotExit() {
        String description = "spu传入值不为0且在映射表不存在,sku不存在在映射表中不存在,BrandName+三级分类 不存在,期望成功";

        int productId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": "+ productId + ",\n" +
                "                \"ProductId\": "+ productId + ",\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": "+ productId + ",\n"+
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }

    /**1、spu传入值不为0且在映射表不存在
     2、sku不存在在映射表中不存在
     3、BrandName+三级分类 存在
     * **/
    @Test
    public void testSkuNotExitAndBrandNameExit() {
        String description = "spu传入值不为0且在映射表不存在,sku不存在在映射表中不存在,BrandName+三级分类 存在,期望成功";

        int productId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\": "+ productId + ",\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": \"品牌\",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }

    /**1、当前skuId的BrandName与现存名称不一致
     2、BrandName+categoryId在Brand表中不存在
     * **/
    @Test
    public void testCategoryAndBrandNameNotExit() {
        String description = "当前skuId的BrandName与现存名称不一致,BrandName+categoryId在Brand表中不存在 存在,期望成功";

        int productId = (int) (System.currentTimeMillis()/1000);
        String json = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"ProductCenterAPIService.MroService.CreateUpdateProducts\",\n" +
                "    \"params\": {\n" +
                "        \"modelList\": [\n" +
                "            {\n" +
                "                \"CategoryId\": 910010101,\n" +
                "                \"ProductCommonId\": 91001,\n" +
                "                \"ProductId\": 120001,\n" +
                "                \"ProductName\": \"测试\",\n" +
                "                \"Model\": \"规格\",\n" +
                "                \"BrandName\": "+productId +",\n" +
                "                \"CommonStatus\": 1 \n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"id\": 1\n" +
                "}";
        mroUpdateProductApiUtils.assertExitResult(json,url,className,description);
    }


}
