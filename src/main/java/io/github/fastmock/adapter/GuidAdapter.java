package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;

import java.util.UUID;

/**
 * 随机生成一个 GUID。
 * Created by wangkun23 on 2022/1/3
 * http://www.broofa.com/2008/09/javascript-uuid-function/
 * [UUID 规范](http://www.ietf.org/rfc/rfc4122.txt)
 *
 * @version : v1.0.0
 **/
public class GuidAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.guid);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        return UUID.randomUUID().toString();
    }
}
