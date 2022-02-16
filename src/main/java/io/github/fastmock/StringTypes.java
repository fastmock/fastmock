package io.github.fastmock;

/**
 * author: wangkun32
 * date: 2022/01/03 18:02
 */
public enum StringTypes {
    // string
    string, bool,
    // int integer float 统一叫做number类型
    number, decimal,
    // user name
    cname, cfirst, clast,
    name, firstname, lastname,
    // date
    now, date, datetime, time, timestamp, year, month,

    guid, uuid,
    // address
    province, city, county,
    // text
    paragraph, sentence, word, title,
    // text chinese
    cparagraph, csentence, cword, ctitle,

    // color
    color, hex, rgb, rgba, hls,

    // media
    image, dataimage,

    // misc
    pick,

    none;

    /**
     * 处理没有匹配到情况
     *
     * @param type String
     * @return valueOfNone
     */
    public static StringTypes valueOfNone(String type) {
        for (StringTypes value : StringTypes.values()) {
            if (value.name().equalsIgnoreCase(type)) {
                return value;
            }
        }
        // 整数类型
        // 在接口层面,是不缺分具体类型的
        if (type.equals("int")
                || type.equals("integer")
                || type.equals("long")) {
            return StringTypes.number;
        }
        // 小数类型
        // 在接口层面,是不缺分具体小数类型的
        if (type.equals("decimal")
                || type.equals("float")
                || type.equals("double")) {
            return StringTypes.decimal;
        }
        // 布尔类型
        if (type.equals("boolean")
                || type.equals("bool")) {
            return StringTypes.bool;
        }
        return none;
    }
}
