package io.github.fastmock.utils;

import com.alibaba.fastjson.JSON;

/**
 * author wangkun23
 * version 1.0.0
 * date 2/8/22 23:32
 */
public class JsonUtils {

    /**
     * 判断是否json对象
     *
     * @param source json
     * @return is json object
     */
    public static boolean isObject(String source) {
        boolean result = false;
        try {
            JSON.parseObject(source);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    /**
     * 判断是否json对象
     *
     * @param source json
     * @return is json object
     */
    public static boolean isArray(String source) {
        boolean result = false;
        try {
            JSON.parseArray(source);
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
}
