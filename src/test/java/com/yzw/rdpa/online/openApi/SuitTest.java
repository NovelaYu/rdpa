package com.yzw.rdpa.online.openApi;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.regex.Pattern;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(Suite.class)
@Suite.SuiteClasses({DeliveryReceiptApiOnlineTest.class, PickInfoListApiOnlineTest.class, ReceiveReceiptInfoApiOnlineTest.class})
/**打包测试**/
public class SuitTest {

    private String dateReg;
    private Pattern pattern;
    /**使用TestRestTemplate 进行http 接口调用**/
    private TestRestTemplate template = new TestRestTemplate();
   /* @Value("8080")// 注入端口号
    private int port;*/

    @Test
    public void test3(){
        String url = "https://api.jc.yzw.cn:8081/open.api";
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("name", "Tom");
        map.add("name1", "Lily");
        String result = template.postForObject(url, map, String.class);
        System.out.println(result);
        assertNotNull(result);
        assertThat(result, Matchers.containsString("Tom"));
    }
}
