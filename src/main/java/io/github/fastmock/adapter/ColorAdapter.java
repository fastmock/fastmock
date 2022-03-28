package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomColor;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/25 20:50
 */
public class ColorAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.color);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        return "#" + RandomColor.hex(6);
    }
}
