package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomDate;

/**
 * 时间函数处理 now
 *
 * author: wangkun32
 * date: 2022/01/03 18:28
 */
public class NowAdapter implements StringTypeAdapter {
    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.now);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        RandomDate randomDate = new RandomDate();
        return randomDate.now();
    }
}
