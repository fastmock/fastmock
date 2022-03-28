package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * author: wangkun32
 * date: 2021/12/27 14:20
 */
@Slf4j
public class IntMockTest {
    @Test
    public void mock() throws IOException {
        Mock mock = new Mock();
        FileReader fileReader = new FileReader("src/test/resources/int.json");
        String template = IOUtils.toString(fileReader);
        JSONObject jsonObject = mock.mock(template);
        log.info("{}", JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
        log.info("{}", IOUtils.toString(fileReader));
    }
}
