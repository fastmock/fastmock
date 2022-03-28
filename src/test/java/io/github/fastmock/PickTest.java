package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

/**
 * @author wangkun23
 * @version 1.0.0
 * @date 2/8/22 23:14
 */
@Slf4j
public class PickTest extends AbstractBaseTest {

    @Test
    public void pick() {
        for (int i = 0; i < 100; i++) {
            String data = "{\"arr\":\"@pick(['a', 'e', 'i', 'o', 'u'])\"}";
            JSONObject jsonObject = mock.mock(data);
            log.info("arr {}", jsonObject.toString());
        }
    }

    @Test
    public void testPick() {
        assertThat(mock.pick("baidu", "alibaba", "jd", "xiaomi"),
                isOneOf("baidu", "alibaba", "jd", "xiaomi"));
    }

    @Test
    public void pickJson() throws IOException {
        FileReader fileReader = new FileReader("src/test/resources/pick.json");
        String template = IOUtils.toString(fileReader);
        JSONObject jsonObject = mock.mock(template);
        log.info("{}", JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
    }
}
