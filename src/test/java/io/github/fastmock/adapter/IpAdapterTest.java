package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class IpAdapterTest {

    @Test
    public void ipv4() {
        IpV4Adapter ipV4Adapter = new IpV4Adapter();
        Object ipv4 = ipV4Adapter.random(new ParseResult(), "@ipv4");
        log.info("{}", ipv4.toString());
    }

    @Test
    public void ipv6() {
        IpV6Adapter ipv6Adapter = new IpV6Adapter();
        Object ipv6 = ipv6Adapter.random(new ParseResult(), "@ipv6");
        log.info("{}", ipv6.toString());
    }
}