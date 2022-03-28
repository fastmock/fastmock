package io.github.fastmock.service;

import io.github.fastmock.*;
import io.github.fastmock.utils.StringUtils;
import io.github.fastmock.adapter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author wangkun23
 * date 3/16/22 22:36
 * version 1.0.0
 */
public class MockValueService {

    private final List<StringTypeAdapter> adapters = new ArrayList<>();
    private final RandomService randomService;

    /**
     * 写完适配类之后,一定要注册到adapters中
     *
     * @param randomService randomService
     */
    public MockValueService(final RandomService randomService) {
        this.randomService = randomService;
        // 基本类型
        adapters.add(new BoolAdapter(randomService));
        adapters.add(new NumberAdapter());
        adapters.add(new DecimalAdapter());

        // 字符串类型
        adapters.add(new CNameAdapter());
        adapters.add(new CFirstNameAdapter());
        adapters.add(new CLastNameAdapter());
        adapters.add(new NameAdapter());
        adapters.add(new LastNameAdapter());
        adapters.add(new FirstNameAdapter());
        // date
        adapters.add(new DateAdapter());
        adapters.add(new DateTimeAdapter());
        adapters.add(new TimeAdapter());
        adapters.add(new NowAdapter());
        // misc
        adapters.add(new GuidAdapter());
        adapters.add(new UuidAdapter());
        // address
        adapters.add(new ProvinceAdapter());
        adapters.add(new CityAdapter());
        adapters.add(new CountyAdapter());
        // text 中文
        adapters.add(new CParagraphAdapter());
        adapters.add(new CSentenceAdapter());
        adapters.add(new CTitleAdapter());
        adapters.add(new CWordAdapter());
        // text english
        adapters.add(new ParagraphAdapter());
        adapters.add(new SentenceAdapter());
        adapters.add(new TitleAdapter());
        adapters.add(new WordAdapter());

        // color
        adapters.add(new ColorAdapter());
        adapters.add(new ColorHexAdapter());
        adapters.add(new RGBAdapter());
        adapters.add(new RGBAAdapter());
        // 图片
        adapters.add(new ImageAdapter());

        // Internet
        adapters.add(new IpV4Adapter());
        adapters.add(new IpV6Adapter());
        // MISC 通用辅助生成
        adapters.add(new PickAdapter());
    }

    /**
     * 注册自定义的实现
     *
     * @param adapter adapter
     */
    public void register(StringTypeAdapter adapter) {
        if (adapter == null) {
            throw new IllegalArgumentException("adapter can not null...");
        }
        adapters.add(adapter);
    }

    /**
     * 为了能通过java方式的api mock数据,单独提供一个只需提供模板格式的方法
     *
     * @param expression expression
     * @return result
     */
    public String resolve(String expression) {
        ParseResult rules = new ParseResult();
        if (!StringUtils.isEmpty(expression)) {
            // @xxxx  > xxxx
            return this.resolveExpression(rules, expression);
        }
        // 如果不是@开头的,则算字符串处理
        return expression;
    }

    /**
     * 处理字符串类型的数据
     *
     * @param key   key
     * @param value value
     * @return string
     */
    public Object string(String key, Object value) {
        ParseResult rules = Parser.parseKey(key);
        String expression = (String) value;
        if (!StringUtils.isEmpty(expression)) {
            // @xxxx  > xxxx
            return this.resolveExpression(rules, expression);
        }
        // 如果不是@开头的,则算字符串处理
        return value;
    }

    /**
     * 解析value值,支持一个多个类型的数据
     *
     * @param rule       rule
     * @param expression value
     * @return result
     */
    protected String resolveExpression(ParseResult rule, String expression) {
        final Pattern expressionPattern = Pattern.compile(Constants.RE_PLACEHOLDER);
        final Matcher matcher = expressionPattern.matcher(expression);
        String result = expression;
        while (matcher.find()) {
            final String escapedType = matcher.group(0);
            final String type = matcher.group(1);
            final String parameters = matcher.group(2);
            if (!StringUtils.isEmpty(parameters)) {
                // 处理参数
                rule.setParameters(parameters);
            }
            // 递归处理解析模板,并替换位置
            String resolved = resolveValueExpression(rule, type, expression);
            if (StringUtils.isEmpty(resolved)) {
                // 如果没有找到匹配的adapter就原样返回
                return expression;
            }
            resolved = resolveExpression(rule, resolved);
            result = StringUtils.replaceOnce(result, escapedType, resolved);
        }
        return result;
    }

    /**
     * 直接解析value的值,最终都是字符串
     *
     * @param rules rules
     * @param type  type
     * @return String
     */
    private String resolveValueExpression(ParseResult rules, String type, Object value) {
        StringTypes stringType = StringTypes.valueOfNone(type);
        StringBuilder builder = new StringBuilder();
        for (StringTypeAdapter stringTypeAdapter : adapters) {
            if (stringTypeAdapter.supports(stringType)) {
                Object random = stringTypeAdapter.random(rules, value);
                builder.append(random);
                break;
            }
        }
        return builder.toString();
    }

    /**
     * 处理bool类型的数据
     *
     * @param key   key
     * @param value value
     * @return bool
     */
    public Object bool(String key, Object value) {
        ParseResult rules = Parser.parseKey(key);
        if (rules.getRange().size() > 0) {
            for (StringTypeAdapter stringTypeAdapter : adapters) {
                if (stringTypeAdapter.supports(StringTypes.bool)) {
                    return stringTypeAdapter.random(rules, value);
                }
            }
        }
        return value;
    }

    /**
     * 处理数值类型的数据
     *
     * @param key   key
     * @param value value
     * @return number
     */
    public Object number(String key, Object value) {
        ParseResult rules = Parser.parseKey(key);
        // 判断是否是小数
        if (rules.getDecimal().size() > 0) {
            for (StringTypeAdapter stringTypeAdapter : adapters) {
                if (stringTypeAdapter.supports(StringTypes.decimal)) {
                    return stringTypeAdapter.random(rules, value);
                }
            }
        }
        // 判断是否是整数
        if (rules.getRange().size() > 0) {
            for (StringTypeAdapter stringTypeAdapter : adapters) {
                if (stringTypeAdapter.supports(StringTypes.number)) {
                    return stringTypeAdapter.random(rules, value);
                }
            }
        }
        return value;
    }
}
