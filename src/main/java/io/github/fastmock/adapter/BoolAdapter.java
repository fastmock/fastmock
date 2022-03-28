package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.service.RandomService;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 19:25
 */
public class BoolAdapter implements StringTypeAdapter {

    private final RandomService randomService;

    public BoolAdapter(RandomService randomService) {
        this.randomService = randomService;
    }

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.bool);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        return randomService.nextBoolean();
    }
}
