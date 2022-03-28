package io.github.fastmock;

import io.github.fastmock.utils.NumberUtils;
import io.github.fastmock.utils.RandomUtils;
import io.github.fastmock.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析key的格式
 * <p>
 * author: wangkun32
 * date: 2021/12/28 14:13
 */
public class Parser {

    /**
     * topics|3-7.1-9
     * 解析出里面参数
     *
     * @param key key
     * @return 返回解析的规则定义
     */
    public static ParseResult parseKey(String key) {
        ParseResult parseResult = new ParseResult();
        Pattern pattern = Pattern.compile(Constants.RE_KEY);
        Matcher matcher = pattern.matcher(key);
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            // 解析整数部分
            if (!StringUtils.isEmpty(matchResult.group(3))) {
                List<String> range = parseRange(matchResult.group(3));
                parseResult.setRange(range);
                if (range.size() == 1) {
                    int max = NumberUtils.parseInt(range.get(0));
                    int count = RandomUtils.nextInt(max, max);
                    parseResult.setMax(max);
                    parseResult.setCount(count);
                }
                if (range.size() == 2) {
                    int min = NumberUtils.parseInt(range.get(0));
                    int max = NumberUtils.parseInt(range.get(1));
                    if (min > max) {
                        // 如果是参数写错了,则纠正
                        int temp = min;
                        min = max;
                        max = temp;
                    }
                    int count = RandomUtils.nextInt(min, max);
                    parseResult.setMin(min);
                    parseResult.setMax(max);
                    parseResult.setCount(count);
                }
            }
            // 带有小数部分的情况
            if (!StringUtils.isEmpty(matchResult.group(4))) {
                List<String> decimal = parseRange(matchResult.group(4));
                parseResult.setDecimal(decimal);

                if (decimal.size() == 1) {
                    int dmax = NumberUtils.parseInt(decimal.get(0));
                    int dcount = RandomUtils.nextInt(dmax, dmax);
                    parseResult.setDmax(dmax);
                    parseResult.setDcount(dcount);
                }
                if (decimal.size() == 2) {
                    int dmin = NumberUtils.parseInt(decimal.get(0));
                    int dmax = NumberUtils.parseInt(decimal.get(1));
                    int dcount = RandomUtils.nextInt(dmin, dmax);
                    if (dmin > dmax) {
                        // 如果是参数写错了,则纠正
                        int temp = dmin;
                        dmin = dmax;
                        dmax = temp;
                    }
                    parseResult.setDmin(dmin);
                    parseResult.setDmax(dmax);
                    parseResult.setDcount(dcount);
                }
            }
        }
        return parseResult;
    }

    /**
     * 解析数值范围
     *
     * @param range range
     * @return parseRange
     */
    private static List<String> parseRange(String range) {
        Pattern pattern = Pattern.compile(Constants.RE_RANGE);
        Matcher matcher = pattern.matcher(range);
        List<String> result = new LinkedList<>();
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            if (!StringUtils.isEmpty(matchResult.group(1))) {
                result.add(matchResult.group(1));
            }
            if (!StringUtils.isEmpty(matchResult.group(2))) {
                result.add(matchResult.group(2));
            }
            return result;
        }
        throw new IllegalArgumentException("invalid range style");
    }
}
