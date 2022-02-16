package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangkun23
 * @version 1.0.0
 * @date 2022/1/26 22:29
 */
@Slf4j
public class PlaceHolderTest {

    @Test
    public void parse() {
        String object = "'test',1,2,3";
        String res = object.replaceAll("\'", "").replaceAll("\"", "");
        log.info("Full match: {}", JSON.toJSONString(res.split(",")));
    }


    @Test
    public void email() {
        final String value = "@user('test',1,2,3)@email";
        List<Schema> schemas = Parser.parseValue(value);
        log.info("Full match: {}", JSON.toJSONString(schemas));
    }
}
