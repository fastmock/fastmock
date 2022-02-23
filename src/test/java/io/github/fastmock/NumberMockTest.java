package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author wangkun23
 * date 2/22/22 22:52
 * version 1.0.0
 */
@Slf4j
public class NumberMockTest {

    @Test
    public void number() {
        Mock mock = new Mock();
        String number1 = "{\"number|50-100.2-4\": 10.9}";
        JSONObject jsonObject = mock.mock(number1);
        log.info("{}", jsonObject.toString());
    }
}
