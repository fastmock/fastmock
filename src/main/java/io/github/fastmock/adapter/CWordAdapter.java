package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomText;

/**
 * 随机生成一个中文词汇
 * Created by wangkun23 on 2022/1/4
 *
 * @version : v1.0.0
 **/
public class CWordAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.cword);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        if (rules.getMin() == 0 ||
                rules.getMax() == 0) {
            rules.setDmin(12);
            rules.setMax(18);
        }
        return RandomText.cword(rules.getMin(), rules.getMax());
    }
}