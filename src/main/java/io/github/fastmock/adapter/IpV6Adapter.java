package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;

/**
 * author wangkun23
 * date 2/23/22 22:32
 * version 1.0.0
 */
public class IpV6Adapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.ipv6);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if (i > 0) {
                builder.append(":");
            }
            builder.append(Integer.toHexString(RandomBasic.nextInt(0, 16)));
            builder.append(Integer.toHexString(RandomBasic.nextInt(0, 16)));
            builder.append(Integer.toHexString(RandomBasic.nextInt(0, 16)));
            builder.append(Integer.toHexString(RandomBasic.nextInt(0, 16)));
        }
        return builder.toString();
    }
}
