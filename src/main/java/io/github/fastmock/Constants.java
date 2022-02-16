package io.github.fastmock;

/**
 * author: wangkun32
 * date: 2021/12/28 13:06
 */
public class Constants {
    public final static Integer GUID = 1;
    public final static String RE_KEY = "(.+)\\|(?:\\+(\\d+)|([\\+\\-]?\\d+-?[\\+\\-]?\\d*)?(?:\\.(\\d+-?\\d*))?)";
    public final static String RE_RANGE = "([\\+\\-]?\\d+)-?([\\+\\-]?\\d+)?";
    public final static String RE_PLACEHOLDER = "\\\\*@([^@#%&()\\?\\s]+)(?:\\((.*?)\\))?";
}
