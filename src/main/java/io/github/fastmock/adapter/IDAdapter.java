package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;

import java.util.UUID;

/**
 * 随机生成一个身份证号码
 * Created by wangkun23 on 2022/1/3
 *
 * @version : v1.0.0
 **/
public class IDAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.guid);
    }


    @Override
    public Object random(ParseResult rules, String key, Object value) {
        return UUID.randomUUID().toString();
    }
}
