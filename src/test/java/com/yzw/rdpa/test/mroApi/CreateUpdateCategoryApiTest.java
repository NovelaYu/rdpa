package com.yzw.rdpa.test.mroApi;

import com.yzw.rdpa.RdpaApplication;
import com.yzw.rdpa.assertUtil.MroUpdateCategoryApiUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@SpringBootTest(classes= RdpaApplication.class)
/**
 ** AbstractTestNGSpringContextTests：测试类只有继承了该类才能拥有注入实例能力，否则注入报错
 *** AbstractTransactionalTestNGSpringContextTests：测试类继承该类后拥有注入实例能力，同时拥有事物控制能力
 **/
public class CreateUpdateCategoryApiTest extends AbstractTestNGSpringContextTests {

    private String url = "http://service.productcenter.yzw.cn.qa:8002/json.rpc";
    private String className = Thread.currentThread().getStackTrace()[1].getClassName();


    /**生成测试报告**/
    private static MroUpdateCategoryApiUtils mroUpdateCategoryApiUtils;

    @BeforeClass
    public static void beforeClass() {
        mroUpdateCategoryApiUtils = new MroUpdateCategoryApiUtils();
    }


    @Test
    public void testNomalParams() {
        String description = "传入正常的参数(categoryId 以0开头，001)，期望：自动转成整数1,返回结果正常";
        int categoryId = (int) (System.currentTimeMillis()/1000);

        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": \"001\",\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertExitResult(json,url,className,description);
    }


    @Test
    public void testCategoryIdInt() {
        String description = "传入分类编码id(CategoryId:sdsd)为字符串，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": \"sdsd\",\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdNegative() {
        String description = "传入分类编码id为负数(CategoryId:-1)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": -1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdEmpty() {
        String description = "传入分类编码id为空字符串(CategoryId:'')，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": \"\",\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryIdNull() {
        String description = "传入分类编码id为Null(CategoryId:null)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": Null,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testParentCategoryIdInt() {
        String description = "传入父级分类编码id(ParentCategoryId:sssd)为字符串，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": \"sssd\",\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testParentCategoryIdNegative() {
        String description = "传入父级分类编码id为负数(ParentCategoryId:-1)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 1,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testParentCategoryIdEmpty() {
        String description = "传入父级分类编码id为空字符串(ParentCategoryId:'')，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": \"\",\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testParentCategoryIdNull() {
        String description = "传入父级分类编码id为Null(ParentCategoryId:null)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": Null,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testErrorCommonStatus() {
        String description = "传入状态值的参数(CommonStatus不在枚举范围，20)，期望，返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 001,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 20 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCommonStatusEmpty() {
        String description = "传入状态值为空字符串(CommonStatus:'')，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": \"\" }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCommonStatusNull() {
        String description = "传入状态值为Null(CommonStatus:null)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": Null }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testIsLeafEmpty() {
        String description = "传入IsLeaf为空字符串(IsLeaf:'')，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": \"\"," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testIsLeafNull() {
        String description = "传入IsLeaf为Null(IsLeaf:null)，期望返回结果报错";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": Null," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }


    @Test
    public void testCategoryNameEmpty() {
        String description = "传入分类编码名称为空字符串(CategoryName:'')，期望返回结果报错";

        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\": \"\",\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testCategoryNameNull() {
        String description = "传入分类编码名称为Null(CategoryName:null)，期望返回结果报错";

        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\": Null,\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testUpdateTimeAndStatus() {
        String description = "更新 categoryId 为1数据，CommonStatus 改为1，期望 状态时间都做更新";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 1,\"ParentCategoryId\": 0,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testInsertCategoryId() {
        String description = "取当前时间戳作为categoryId，插入新的categoryId,期望更新成功";
        int categoryId = (int) (System.currentTimeMillis()/1000);

        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":"+ categoryId + ","+
                "\"ParentCategoryId\": 0,\"CategoryName\": Null,\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    /**同一级类名不能重复
     * 第一级分类不能重复
     * **/
    @Test
    public void testFirstSameCategoryName() {
        String description = "ParentCategoryId 为0,第一级分类名称重复，CategoryName 改为 测试分类12 ，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 7,\"ParentCategoryId\": 5,\"CategoryName\": \"测试分类\",\"IsLeaf\": true," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    /**
     * 第二级分类不能重复
     * **/
    @Test
    public void testSecondSameCategoryName() {
        String description = "ParentCategoryId 2，ifLeaf值为false,第二级级分类名称重复，CategoryName 改为 测试分类 ，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 4,\"ParentCategoryId\": 2,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    /**父类code和子类code是需要匹配**/
    @Test
    public void testChildNotWithParent() {
        String description = "父类id和子类id是否匹配，需要校验：ParentCategoryId为1，categoryId取5,父级分类id应该为2，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\": 5,"+
                "\"ParentCategoryId\": 1,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testChildSameParent() {
        String description = "父类id和子类id是否匹配，需要校验：ParentCategoryId为1，categoryId为1，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":1,"+
                "\"ParentCategoryId\": 1,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    /**插入第三级分类功能校验**/
    @Test
    public void testFirstCategoryLeafIsTrue() {
        String description = "第一级分类categoryId 为1，isLeaf为true，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":1,"+
                "\"ParentCategoryId\": 1,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": true," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testSecondCategoryLeafIsTrue() {
        String description = "第二级分类categoryId 为 3，isLeaf为true，期望更新失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":3,"+
                "\"ParentCategoryId\": 2,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": true," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testThirdCategoryLeafIsTrue() {
        String description = "第三级分类categoryId 为 4，isLeaf为true，期望成功";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":4,"+
                "\"ParentCategoryId\": 3,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": true," +
                "\"CommonStatus\": 1 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testThirdCategoryLeafIsFalse() {
        String description = "第三级分类categoryId 为 4，isLeaf为false，期望失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":4,"+
                "\"ParentCategoryId\": 3,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 0 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    @Test
    public void testFourthCategoryLeafIsFalse() {
        String description = "超过三级分类，传入第四级分类，ParentCategoryId 为4，isLeaf为false，期望失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":"+ categoryId + "," +
                "\"ParentCategoryId\": 4,\"CategoryName\":"+ categoryId + "\"IsLeaf\": false," +
                "\"CommonStatus\": 2 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }

    /**不允许修改父级code**/

    @Test
    public void testUpdateParentCategory() {
        String description = "CategoryId 的父级Id为3，将ParentCategoryId 改为2，期望失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":4,"+
                "\"ParentCategoryId\": 2,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 2 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }


    @Test
    public void testUpdateCommonStatus() {
        String description = "将 CommonStatus 由0 变为1，期望成功";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":3,"+
                "\"ParentCategoryId\": 2,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 1 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertExitResult(json,url,className,description);
    }

    @Test
    public void testUpdateElseCommonStatus() {
        String description = "将 CommonStatus 由1 变为2，期望失败";

        int categoryId = (int) (System.currentTimeMillis()/1000);
        String json = "{\"jsonrpc\": \"2.0\", \"method\": \"ProductCenterAPIService.MroService.CreateUpdateCategory\", " +
                "\"params\": { \"model\": { \"CategoryId\":3,"+
                "\"ParentCategoryId\": 2,\"CategoryName\":" +categoryId+","+ "\"IsLeaf\": false," +
                "\"CommonStatus\": 2 }},\"id\": 1}";
        mroUpdateCategoryApiUtils.assertErrorResult(json,url,className,description);
    }



}
