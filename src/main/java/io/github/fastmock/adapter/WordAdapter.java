package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomText;

/**
 * Created by wangkun23 on 2022/1/4
 *
 * @version : v1.0.0
 **/
public class WordAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.word);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        if (rules.getMin() == 0 || rules.getMax() == 0) {
            rules.setDmin(3);
            rules.setMax(7);
        }
        return RandomText.word(rules.getMin(), rules.getMax());
    }
}