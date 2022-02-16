package io.github.fastmock;

/**
 * author: wangkun32
 * date: 2021/12/28 17:49
 */
public interface StringTypeAdapter {
    /**
     * 判断是否支持该参数类型的
     *
     * @param type type
     * @return supports
     */
    boolean supports(StringTypes type);

    /**
     * 处理结果
     *
     * @param rules rules
     * @param key   key
     * @param value value
     * @return random
     */
    Object random(ParseResult rules, String key, Object value);
}
