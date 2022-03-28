package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/25 20:50
 */
public class RGBAAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.rgba);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        StringBuilder builder = new StringBuilder().append("rgba(")
                .append(RandomBasic.nextInt(0, 255)).append(",")
                .append(RandomBasic.nextInt(0, 255)).append(",")
                .append(RandomBasic.nextInt(0, 255)).append(",")
                .append(RandomBasic.nextFloat(0, 1, 1, 2))
                .append(")");
        return builder.toString();
    }
}
