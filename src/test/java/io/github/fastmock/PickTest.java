package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wangkun23
 * @version 1.0.0
 * @date 2/8/22 23:14
 */
@Slf4j
public class PickTest {

    @Test
    public void pick() {
        Mock mock = new Mock();
        for (int i = 0; i < 100; i++) {
            String data = "{\"arr\":\"@pick(['a', 'e', 'i', 'o', 'u'])\"}";
            JSONObject jsonObject = mock.mock(data);
            log.info("image1 {}", jsonObject.toString());
        }
    }
}
