package io.github.fastmock.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;

/**
 * author wangkun23
 * date 3/27/22 19:51
 * version 1.0.0
 */
@Slf4j
public class MockValueServiceTest {

    @Test
    public void mock() throws IOException {
        MockValueService mockValueService = new MockValueService( new RandomService());
        String resolve = mockValueService.resolve("@notExist");
        log.info("{}", resolve);
        String color = mockValueService.resolve("@color");
        log.info("{}", color);
    }
}
