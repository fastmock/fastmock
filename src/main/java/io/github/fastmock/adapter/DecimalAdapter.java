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
 * 小数的类型
 * 虽然在java里面是区分float double 为了统一化都归纳为decimal类型
 * <p>
 * author wangkun23
 * version 1.0.0
 * date 2022/1/26 20:11
 */
public class DecimalAdapter implements StringTypeAdapter {

    @Override
    public boolean supports(StringTypes type) {
        return type.equals(StringTypes.decimal);
    }

    @Override
    public Object random(ParseResult rules, String key, Object value) {
        // TODO.. 合并参数
        // List<String> parameters = Arrays.asList(rules.getParameters().split(","));
        List<String> range = rules.getRange();
        List<String> decimal = rules.getDecimal();
        if (range.size() == 1) {
            int max = NumberUtils.parseInt(range.get(0));
            rules.setMax(max);
            rules.setCount(max);
        }
        if (range.size() == 2) {
            int min = NumberUtils.parseInt(range.get(0));
            int max = NumberUtils.parseInt(range.get(1));
            int count = RandomUtils.nextInt(min, max);
            rules.setMin(min);
            rules.setMax(max);
            rules.setCount(count);
        }
        if (decimal.size() == 1) {
            int dmax = NumberUtils.parseInt(decimal.get(0));
            rules.setDmin(dmax);
            rules.setDmax(dmax);
            rules.setDcount(dmax);
        }

        if (decimal.size() == 2) {
            int dmin = NumberUtils.parseInt(decimal.get(0));
            int dmax = NumberUtils.parseInt(decimal.get(1));
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
        return RandomBasic.nextFloat(rules.getMin(), rules.getMax(), rules.getDmin(), rules.getDmax());
    }
}
