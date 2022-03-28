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
    public Object random(ParseResult rules, Object value) {
        // 合并参数
        // 如果parameters 有值,则忽略key里面设定的参数值
        if (!StringUtils.isEmpty(rules.getParameters())) {
            List<String> parameters = Arrays.asList(rules.getParameters().split(","));
            rules.setRange(parameters);
        }
        List<String> range = rules.getRange();
        List<String> decimal = rules.getDecimal();
        if (range.size() == 1) {
            int max = NumberUtils.parseInt(range.get(0));
            rules.setMax(max);
        }
        if (range.size() == 2) {
            int min = NumberUtils.parseInt(range.get(0));
            int max = NumberUtils.parseInt(range.get(1));
            rules.setMin(min);
            rules.setMax(max);
        }
        if (decimal.size() == 1) {
            int dmax = NumberUtils.parseInt(decimal.get(0));
            rules.setDmin(dmax);
            rules.setDmax(dmax);
        }

        if (decimal.size() == 2) {
            int dmin = NumberUtils.parseInt(decimal.get(0));
            int dmax = NumberUtils.parseInt(decimal.get(1));
            rules.setDmin(dmin);
            rules.setDmax(dmax);
        }
        if (rules.getMin() == 0 && rules.getMax() == 0) {
            rules.setMin(1);
            rules.setMax(100);
        }
        if (rules.getMax() == 0
                || rules.getMax() < rules.getMin()) {
            rules.setMax(rules.getMin());
        }
        if (rules.getDmin() == 0 && rules.getDmax() == 0) {
            rules.setDmin(2);
            rules.setDmax(2);
        }
        return RandomBasic.nextFloat(rules.getMin(), rules.getMax(), rules.getDmin(), rules.getDmax());
    }
}
