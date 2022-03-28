package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;

import java.util.Arrays;

/**
 * author wangkun23
 * date 2/23/22 22:32
 * version 1.0.0
 */
public class IpV4Adapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.ip) || type.equals(StringTypes.ipv4);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        final int[] PRIVATE_FIRST_OCTET = {10, 127, 169, 192, 172};

        int first = RandomBasic.nextInt(0, 256);
        int second = RandomBasic.nextInt(0, 256);
        int third = RandomBasic.nextInt(0, 256);
        int fourth = RandomBasic.nextInt(0, 256);

        while (Arrays.binarySearch(PRIVATE_FIRST_OCTET, first) > 0) {
            first = RandomBasic.nextInt(0, 256);
        }
        final StringBuilder builder = new StringBuilder();
        builder.append(first).append(".")
                .append(second).append(".")
                .append(third).append(".")
                .append(fourth).append(".");
        return builder.toString();
    }
}
