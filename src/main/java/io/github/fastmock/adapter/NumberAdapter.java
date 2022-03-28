package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;
import io.github.fastmock.utils.NumberUtils;
import io.github.fastmock.utils.RandomUtils;
import io.github.fastmock.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 整数的类型
 * 虽然在java里面是区分, int integer long, 为了统一化都归纳为number类型
 * <p>
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 19:25
 */
public class NumberAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.number);
    }

    @Override
    public Object random(ParseResult rules, Object value) {
        // 如果parameters 有值,则忽略key里面设定的参数值
        if (!StringUtils.isEmpty(rules.getParameters())) {
            List<String> parameters = Arrays.asList(rules.getParameters().split(","));
            rules.setRange(parameters);
        }
        List<String> range = rules.getRange();
        if (range.size() == 1) {
            int max = NumberUtils.parseInt(rules.getRange().get(0));
            int count = RandomUtils.nextInt(0, max);
            rules.setMax(max);
            rules.setCount(count);
        }
        if (range.size() == 2) {
            int min = NumberUtils.parseInt(rules.getRange().get(0));
            int max = NumberUtils.parseInt(rules.getRange().get(1));
            int count = RandomUtils.nextInt(min, max);
            rules.setMin(min);
            rules.setMax(max);
            rules.setCount(count);
        }
        if (rules.getMin() == 0 && rules.getMax() == 0) {
            return RandomBasic.nextNatural(1, 100);
        }
        if (rules.getMax() == 0
                || rules.getMax() < rules.getMin()) {
            rules.setMax(rules.getMin());
        }
        return RandomBasic.nextNatural(rules.getMin(), rules.getMax());
    }
}
