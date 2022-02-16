package io.github.fastmock;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.github.fastmock.random.RandomBasic;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by wangkun23 on 2022/1/2
 *
 * @version : v1.0.0
 **/
@Slf4j
public class AppTest {
    @Test
    public void parseKey() {
        String value = "@bool@343";
        log.info("{}", value.substring(1));
    }

    @Test
    public void anFloat() {
        log.info("{}", RandomBasic.nextFloat(1, 1000, 2, 2));
    }

    @Test
    public void hasArray() {
        String array = "[\"a\", \"e\", \"i\", \"o\", \"u\"]";
        JSONArray jsonArray = JSON.parseArray(array);
        log.info("{}", jsonArray);
    }
}
