package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomName;

/**
 * 中文姓 周 武 郑 王
 * <p>
 * author: wangkun32
 * date: 2022/01/03 15:24
 */
public class CFirstNameAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.cfirst);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        RandomName randomName = new RandomName();
        return randomName.cfirst();
    }
}
