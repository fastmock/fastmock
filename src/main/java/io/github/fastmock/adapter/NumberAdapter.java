package io.github.fastmock.adapter;

import io.github.fastmock.ParseResult;
import io.github.fastmock.StringTypeAdapter;
import io.github.fastmock.StringTypes;
import io.github.fastmock.random.RandomBasic;
import io.github.fastmock.utils.NumberUtils;
import io.github.fastmock.utils.RandomUtils;

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
    public Object random(ParseResult rules, String key, Object value) {
        List<String> parameters = Arrays.asList(rules.getParameters().split(","));
        if (parameters.size() == 1) {
            int max = NumberUtils.parseInt(parameters.get(0));
            int count = RandomUtils.nextInt(0, max);
            rules.setMax(max);
            rules.setCount(count);
        }
        if (parameters.size() == 2) {
            int min = NumberUtils.parseInt(parameters.get(0));
            int max = NumberUtils.parseInt(parameters.get(1));
            int count = RandomUtils.nextInt(min, max);
            rules.setMin(min);
            rules.setMax(max);
            rules.setCount(count);
        }
        if (parameters.size() == 3) {
            int max = NumberUtils.parseInt(parameters.get(2));
            int count = RandomUtils.nextInt(0, max);
            rules.setMax(max);
            rules.setCount(count);
            int dmax = NumberUtils.parseInt(parameters.get(2));
            int dcount = RandomUtils.nextInt(0, dmax);
            rules.setDmax(dmax);
            rules.setDcount(dcount);
        }

        if (parameters.size() == 4) {
            int min = NumberUtils.parseInt(parameters.get(0));
            int max = NumberUtils.parseInt(parameters.get(1));
            int count = RandomUtils.nextInt(min, max);
            rules.setMin(min);
            rules.setMax(max);
            rules.setCount(count);

            int dmin = NumberUtils.parseInt(parameters.get(2));
            int dmax = NumberUtils.parseInt(parameters.get(3));
            int dcount = RandomUtils.nextInt(dmin, dmax);
            rules.setDmin(dmin);
            rules.setDmax(dmax);
            rules.setDcount(dcount);
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
