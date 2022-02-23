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
 * author wangkun23
 * date 2/20/22 23:35
 * version 1.0.0
 */
@Slf4j
public class GettingStart {
    @Test
    public void mock() throws IOException {
        Mock mock = new Mock();
        FileReader fileReader = new FileReader("src/test/resources/getting_start.json");
        String template = IOUtils.toString(fileReader);
        JSONObject jsonObject = mock.mock(template);
        log.info("{}", JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
    }
}
