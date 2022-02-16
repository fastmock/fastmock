package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 19:25
 */
public class BoolAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.bool);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        return RandomBasic.nextBool();
    }
}
