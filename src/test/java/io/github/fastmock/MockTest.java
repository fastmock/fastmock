package io.github.fastmock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * author wangkun23
 * date 3/27/22 19:42
 * version 1.0.0
 */
@Slf4j
public class MockTest {

    @Test
    public void mockMe() {
        Mock mock = new Mock();
        String pick = mock.pick("10", "56", "60");
        log.info("pick {}", pick);
    }
}
