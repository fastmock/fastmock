package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author: wangkun32
 * date: 2021/12/27 14:20
 */
@Slf4j
public class ColorMockTest {
    @Test
    public void color() {
        Mock mock = new Mock();
        String data = "{\"color\":\"@color @name\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("{}", jsonObject.toString());
    }

    @Test
    public void hex() {
        Mock mock = new Mock();
        String data = "{\"hex\":\"@hex\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("{}", jsonObject.toString());
    }

    @Test
    public void rgb() {
        Mock mock = new Mock();
        String data = "{\"rgb\":\"@rgb\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("{}", jsonObject.toString());
    }

    @Test
    public void rgba() {
        Mock mock = new Mock();
        String data = "{\"rgba\":\"@rgba\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("{}", jsonObject.toString());
    }
}
