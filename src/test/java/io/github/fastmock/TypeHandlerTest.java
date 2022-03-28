package io.github.fastmock;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static io.github.fastmock.MatchesRegularExpression.matchesRegularExpression;
import static org.junit.Assert.assertThat;

/**
 * author wangkun23
 * date 3/20/22 15:24
 * version 1.0.0
 */
@Slf4j
public class TypeHandlerTest {

    @Test
    public void object() {
        TypeHandler typeHandler = new TypeHandler(new Mock());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "@name");
        JSONObject resolve = typeHandler.resolve(jsonObject);
        assertThat(resolve.getString("name"), matchesRegularExpression("([\\w']+\\.?( )?){2,4}"));
    }
}
