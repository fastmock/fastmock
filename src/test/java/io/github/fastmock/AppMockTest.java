package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.github.fastmock.random.RandomName;
import io.github.fastmock.utils.MockUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: wangkun32
 * date: 2021/12/27 14:20
 */
@Slf4j
public class AppMockTest {
    @Test
    public void mock() throws IOException {
        Mock mock = new Mock();
        FileReader fileReader = new FileReader("src/test/resources/topics.json");
        String template = IOUtils.toString(fileReader);
        JSONObject jsonObject = mock.mock(template);
        log.info("{}", JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
        log.info("{}", IOUtils.toString(fileReader));
    }

    @Test
    public void randomName() {
        RandomName randomName = new RandomName();
        log.info("name: {}", randomName.name());
        log.info("cname: {}", randomName.cname());
    }

    @Test
    public void parseKey() {
        String key = "topic_title|10-5.4-5";
        ParseResult result = Parser.parseKey(key);
        log.info("name: {}", MockUtils.parsedName(key));
        log.info("result: {}", result);
    }

}
