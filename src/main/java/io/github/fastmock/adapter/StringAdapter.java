package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 19:25
 */
public class StringAdapter implements StringTypeAdapter {
    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.string);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rules.getCount(); i++) {
            builder.append(value);
        }
        return builder.toString();
    }
}
