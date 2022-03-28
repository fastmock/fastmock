package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomName;

/**
 * author: wangkun32
 * date: 2022/01/03 17:23
 */
public class NameAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.name);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        RandomName randomName = new RandomName();
        return randomName.name();
    }
}
