package io.github.fastmock.adapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;
import io.github.fastmock.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 随机选择器
 * '@pick(["a", "e", "i", "o", "u"])'
 *
 * author wangkun23
 * version 1.0.0
 * date 2/8/22 23:11
 */
@Slf4j
public class PickAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.pick);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        if (JsonUtils.isArray(rules.getParameters())) {
            JSONArray jsonArray = JSON.parseArray(rules.getParameters());
            int nextInt = RandomBasic.nextInt(0, jsonArray.size() - 1);
            return jsonArray.getString(nextInt);
        }
        return value;
    }
}