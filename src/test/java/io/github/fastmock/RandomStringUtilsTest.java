package io.github.fastmock;

import io.github.fastmock.random.RandomText;
import io.github.fastmock.utils.RandomStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by wangkun23 on 2022/1/4
 *
 * @version : v1.0.0
 **/
@Slf4j
public class RandomStringUtilsTest {
    @Test
    public void test() {
        // eCGiZMddYqy3DprBQHbZ3sNfKYeMBM8ByDOhxoLVxiG0
        log.info("randomAlphanumeric {}", RandomStringUtils.randomAlphanumeric(100));
        // TWHmGSdaxTmWWaEDGtAoNMSEbCsOlrjfbOyVeBDmhyHwvIsvRBCwu
        log.info("randomAlphabetic {}", RandomStringUtils.randomAlphabetic(1));
        // ;@sIt'U^p|jiRPG<|.:x~`&[p"v3Pv9R e:ywk_o{N(
        log.info("randomAscii {}", RandomStringUtils.randomAscii(100));
        log.info("randomAscii {}", RandomStringUtils.randomNumeric(5, 10));
        log.info("randomAscii {}", RandomStringUtils.randomPrint(100));
        log.info("randomAscii {}", RandomStringUtils.randomGraph(100));
        log.info("randomAscii {}", RandomText.cword(2, 2));
    }
}
