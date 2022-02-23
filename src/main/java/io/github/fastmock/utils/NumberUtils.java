package io.github.fastmock.utils;

/**
 * author wangkun23
 * version 1.0.0
 * date 2/9/22 22:22
 */
public class NumberUtils {

    /**
     * 自定义整型数值转换
     *
     * @param s 输入的字符串
     * @return 如果转换错误则返回 1
     */
    public static Integer parseInt(String s) {
        try {
            return !StringUtils.isEmpty(s) ? Integer.parseInt(s) : 0;
        } catch (NumberFormatException ex) {
            // Nothing
            return 0;
        }
    }

}
