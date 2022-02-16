package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomName;

/**
 * 中文名
 * <p>
 * author: wangkun32
 * date: 2022/01/03 15:24
 */
public class CLastNameAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.clast);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        RandomName randomName = new RandomName();
        return randomName.clast();
    }
}