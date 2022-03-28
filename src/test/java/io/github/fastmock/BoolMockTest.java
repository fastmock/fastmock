package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

/**
 * author wangkun23
 * date 2/22/22 22:52
 * version 1.0.0
 */
@Slf4j
public class BoolMockTest extends AbstractBaseTest {

    @Test
    public void bool() {
        String bool1 = "{\"bool|1\": false}";
        JSONObject jsonObject = mock.mock(bool1);
        log.info("{}", jsonObject.toString());
        Assert.assertThat(jsonObject.getBoolean("bool"), isOneOf(true, false));
    }

    @Test
    public void testBool() {
        assertThat(mock.nextBoolean(), isOneOf(true, false));
    }
}
