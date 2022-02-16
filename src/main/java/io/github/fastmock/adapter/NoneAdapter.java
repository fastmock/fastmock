package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;

/**
 * 时间函数处理
 *
 * author: wangkun32
 * date: 2022/01/03 18:28
 */
public class NoneAdapter implements StringTypeAdapter {
    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.none);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        return value;
    }
}
