package io.github.fastmock.utils;

import io.github.fastmock.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: wangkun32
 * date: 2021/12/28 21:16
 */
public class MockUtils {
    /**
     * 提取key中中字段名
     * "topic_title|3-7" parse to topic_title
     *
     * @param key key
     * @return parsedName
     */
    public static String parsedName(String key) {
        Pattern pattern = Pattern.compile(Constants.RE_KEY);
        Matcher matcher = pattern.matcher(key);
        if (matcher.find()) {
            return matcher.toMatchResult().group(1);
        }
        return key;
    }
}
