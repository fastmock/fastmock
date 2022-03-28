package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomDate;

/**
 * 时间函数处理 date
 *
 * author: wangkun32
 * date: 2022/01/03 18:28
 */
public class DateAdapter implements StringTypeAdapter {
    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.date);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        RandomDate randomDate = new RandomDate();
        return randomDate.date();
    }
}
