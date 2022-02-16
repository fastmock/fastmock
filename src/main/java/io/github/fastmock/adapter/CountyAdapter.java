package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomAddress;

/**
 * 中国-省份-城市-县
 * Created by wangkun23 on 2022/1/3
 *
 * @version : v1.0.0
 **/
public class CountyAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.county);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        RandomAddress randomAddress = new RandomAddress();
        return randomAddress.county(false);
    }
}
