package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomName;

/**
 * author: wangkun32
 * date: 2022/01/03 17:23
 */
public class CNameAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.cname);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        RandomName randomName = new RandomName();
        return randomName.cname();
    }
}
