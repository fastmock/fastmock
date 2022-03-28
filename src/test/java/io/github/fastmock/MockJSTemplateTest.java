package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wangkun23
 * @version 1.0.0
 * @date 2022/1/26 19:10
 */
@Slf4j
public class MockJSTemplateTest {

    @Test
    public void numberTest() {
        Mock mock = new Mock();
        String number = "{\"age\": \"@number(1,100)\"}";
        JSONObject jsonObject = mock.mock(number);
        log.info("number {}", jsonObject.toString());

        String nextInt = "{\"int\": \"@int\"}";
        JSONObject nextIntObject = mock.mock(nextInt);
        log.info("int {}", nextIntObject.toString());

        String nextInt2 = "{\"int1|5\": 1}";
        JSONObject nextIntObject2 = mock.mock(nextInt2);
        log.info("int {}", nextIntObject2.toString());

        String nextInteger = "{\"integer\": \"@integer\"}";
        JSONObject nextIntegerObject = mock.mock(nextInteger);
        log.info("integer {}", nextIntegerObject.toString());
    }

    @Test
    public void bool() {
        Mock mock = new Mock();
        String data = "{\"boolean|+1\": \"@bool\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("{}", jsonObject.toString());
    }

    @Test
    public void decimal() {
        Mock mock = new Mock();
        String decimal = "{\"decimal\": \"@decimal\"}";
        JSONObject decimalObject = mock.mock(decimal);
        log.info("decimal {}", decimalObject.toString());

        String nextFloat = "{\"float\": \"@float(1,10,5)\"}";
        JSONObject nextFloatObject = mock.mock(nextFloat);
        log.info("float {}", nextFloatObject.toString());


        String nextDouble = "{\"float|1-10.2\": \"@double\"}";
        JSONObject nextDoubleObject = mock.mock(nextDouble);
        log.info("double {}", nextDoubleObject.toString());
    }

    @Test
    public void cname() {
        Mock mock = new Mock();
        String template = "{\"name\": \"@cname\"}";
        JSONObject result = mock.mock(template);
        log.info("{}", result.toString());
    }

    @Test
    public void cword() {
        Mock mock = new Mock();
        String cword = "{\"cword\": \"@cword\"," +
                "\"ctitle|5\": \"@title\"," +
                "\"cparagraph|5\": \"@paragraph\"," +
                "\"csentence|5\": \"@sentence\"}";
        JSONObject jsonObject = mock.mock(cword);
        log.info("cword {}", jsonObject.toString());
    }

    @Test
    public void array() {
        String template = "{\n" +
                "  \"array|4-4\": [\n" +
                "    \"AMD\",\n" +
                "    \"CMD\",\n" +
                "    \"UMD\"\n" +
                "  ]\n" +
                "}";
        Mock mock = new Mock();
        JSONObject array = mock.mock(template);
        log.info("array {}", array.toString());
    }

    @Test
    public void array2() {
        String template = "{\n" +
                "  \"array|2-2\": [\n" +
                " {\"name\":\"@name\"}" +
                "  ]\n" +
                "}";
        Mock mock = new Mock();
        JSONObject array = mock.mock(template);
        log.info("array {}", array.toString());
    }
}
