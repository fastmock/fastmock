package io.github.fastmock;

import io.github.fastmock.utils.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
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
        String[] ranges = parseRanges(key);
        // 解析整数部分
        if (!StringUtils.isEmpty(ranges[3])) {
            String[] range = parseRange(ranges[3]);
            parseResult.setRange(range);
            int min = !StringUtils.isEmpty(range[1]) ? Integer.parseInt(range[1]) : 0;
            int max = !StringUtils.isEmpty(range[2]) ? Integer.parseInt(range[2]) : 0;
            int count = StringUtils.isEmpty(range[2]) ? Integer.parseInt(range[1]) : RandomUtils.nextInt(min, max);
            parseResult.setRangeMin(min);
            parseResult.setRangeMax(max);
            parseResult.setRangeCount(count);
        }
        return parseResult;
    }

    /**
     * 解析参数
     * 2022-01-27 重新设计mock语法
     *
     * @param value value
     * @return Schemas
     */
    public static List<Schema> parseValue(String value) {
        final Pattern pattern = Pattern.compile(Constants.RE_PLACEHOLDER);
        final Matcher matcher = pattern.matcher(value);
        List<Schema> schemaList = new ArrayList<>();
        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            if (matchResult.group(2) != null) {
//                String[] split = matchResult.group(2).split(",");
//                List<String> parameters = new ArrayList<>(split.length);
//                for (String str : split) {
//                    str = str.replaceAll("'", "");
//                    str = str.replaceAll("\"", "");
//                    parameters.add(str);
//                }
                // 替换调单引号或者双引号
                Schema schema = new Schema(matchResult.group(1), matchResult.group(2));
                schemaList.add(schema);
            } else {
                Schema schema = new Schema(matchResult.group(1));
                schemaList.add(schema);
            }
        }
        return schemaList;
    }

    /**
     * 解析json key参数
     *
     * @param key key
     * @return parseParameters
     */
    private static String[] parseRanges(String key) {
        Pattern pattern = Pattern.compile(Constants.RE_KEY);
        Matcher matcher = pattern.matcher(key);
        String[] result = new String[4];
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            if (!StringUtils.isEmpty(matchResult.group(0))) {
                result[0] = matchResult.group(0);
            }
            if (!StringUtils.isEmpty(matchResult.group(1))) {
                result[1] = matchResult.group(1);
            }
            if (!StringUtils.isEmpty(matchResult.group(2))) {
                result[2] = matchResult.group(2);
            }
            if (!StringUtils.isEmpty(matchResult.group(3))) {
                result[3] = matchResult.group(3);
            }
        }
        return result;
    }

    /**
     * 解析数值范围
     *
     * @param range range
     * @return parseRange
     */
    private static String[] parseRange(String range) {
        Pattern pattern = Pattern.compile(Constants.RE_RANGE);
        Matcher matcher = pattern.matcher(range);
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            String[] result = new String[3];
            if (!StringUtils.isEmpty(matchResult.group(0))) {
                result[0] = matchResult.group(0);
            }
            if (!StringUtils.isEmpty(matchResult.group(1))) {
                result[1] = matchResult.group(1);
            }
            if (!StringUtils.isEmpty(matchResult.group(2))) {
                result[2] = matchResult.group(2);
            }
            return result;
        }
        throw new IllegalArgumentException("invalid range style");
    }
}
