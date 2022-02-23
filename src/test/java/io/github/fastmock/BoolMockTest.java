package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * author wangkun23
 * date 2/22/22 22:52
 * version 1.0.0
 */
@Slf4j
public class BoolMockTest {

    @Test
    public void bool() {
        Mock mock = new Mock();
        String bool1 = "{\"bool|1\": false}";
        JSONObject jsonObject = mock.mock(bool1);
        log.info("{}", jsonObject.toString());
        Assert.assertFalse(jsonObject.getBoolean("bool"));
    }
}
