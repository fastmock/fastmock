package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author: wangkun32
 * date: 2022/02/01 17:50
 */
@Slf4j
public class ImageMockTest {

    @Test
    public void image() {
        Mock mock = new Mock();
        String data = "{\"image\":\"@image('200x100','#894FC4','#FFF','png','Mock')\"}";
        JSONObject jsonObject = mock.mock(data);
        log.info("image1 {}", jsonObject.toString());
    }
}
