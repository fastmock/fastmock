package io.github.fastmock;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * author: wangkun32
 * date: 2021/12/27 14:20
 */
public class AbstractBaseTest {

    @Spy
    protected Mock mock;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }
}
