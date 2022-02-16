//package io.github.fastmock;
//
//import io.github.fastmock.utils.StringUtils;
//import org.apache.commons.lang3.RandomUtils;
//
//import java.util.regex.MatchResult;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * 解析key的格式
// * <p>
// * author: wangkun32
// * date: 2021/12/28 14:13
// */
//public class ParserKey {
//
//    /**
//     * topics|3-7.1-9
//     * 解析出里面参数
//     *
//     * @param key key
//     * @return 返回解析的规则定义
//     */
//    public static ParseResult parse(String key) {
//        ParseResult parseResult = new ParseResult();
//        String[] parameters = parseParameters(key);
//        parseResult.setParameters(parameters);
//        // 解析整数部分
//        if (!StringUtils.isEmpty(parameters[3])) {
//            String[] range = parseRange(parameters[3]);
//            parseResult.setRange(range);
//            int min = !StringUtils.isEmpty(range[1]) ? Integer.parseInt(range[1]) : 0;
//            int max = !StringUtils.isEmpty(range[2]) ? Integer.parseInt(range[2]) : 0;
//            int count = StringUtils.isEmpty(range[2]) ? Integer.parseInt(range[1]) : RandomUtils.nextInt(min, max);
//
//            parseResult.setMin(min);
//            parseResult.setMax(max);
//            parseResult.setCount(count);
//        }
//        // 解析小数部分
//        if (!StringUtils.isEmpty(parameters[4])) {
//            String[] decimal = parseRange(parameters[4]);
//            parseResult.setDecimal(decimal);
//
//            int dmin = !StringUtils.isEmpty(decimal[1]) ? Integer.parseInt(decimal[1]) : 0;
//            int dmax = !StringUtils.isEmpty(decimal[2]) ? Integer.parseInt(decimal[2]) : 0;
//            int dcount = StringUtils.isEmpty(decimal[2])
//                    ? Integer.parseInt(decimal[1]) : RandomUtils.nextInt(dmin, dmax);
//            parseResult.setDmin(dmin);
//            parseResult.setDmax(dmax);
//            parseResult.setDcount(dcount);
//        }
//        return parseResult;
//    }
//
//
//    /**
//     * 解析json key参数
//     *
//     * @param key key
//     * @return parseParameters
//     */
//    private static String[] parseParameters(String key) {
//        Pattern pattern = Pattern.compile(Constants.RE_KEY);
//        Matcher matcher = pattern.matcher(key);
//        String[] result = new String[5];
//        if (matcher.find()) {
//            MatchResult matchResult = matcher.toMatchResult();
//            if (!StringUtils.isEmpty(matchResult.group(0))) {
//                result[0] = matchResult.group(0);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(1))) {
//                result[1] = matchResult.group(1);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(2))) {
//                result[2] = matchResult.group(2);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(3))) {
//                result[3] = matchResult.group(3);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(4))) {
//                result[4] = matchResult.group(4);
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 解析数值范围
//     *
//     * @param range range
//     * @return parseRange
//     */
//    private static String[] parseRange(String range) {
//        Pattern pattern = Pattern.compile(Constants.RE_RANGE);
//        Matcher matcher = pattern.matcher(range);
//        if (matcher.find()) {
//            MatchResult matchResult = matcher.toMatchResult();
//            String[] result = new String[3];
//            if (!StringUtils.isEmpty(matchResult.group(0))) {
//                result[0] = matchResult.group(0);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(1))) {
//                result[1] = matchResult.group(1);
//            }
//            if (!StringUtils.isEmpty(matchResult.group(2))) {
//                result[2] = matchResult.group(2);
//            }
//            return result;
//        }
//        throw new IllegalArgumentException("invalid range style");
//    }
//}
