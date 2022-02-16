package io.github.fastmock;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * author: wangkun32
 * date: 2021/12/28 14:17
 */
@ToString
public class ParseResult {
    @Setter
    @Getter
    // 1 name, 2 range
    // 1 min, 2 max
    private String[] range;

    // 都是数组最小个数
    @Setter
    @Getter
    private int rangeMin = 0;

    // 都是数组最大个数
    @Setter
    @Getter
    private int rangeMax = 0;

    @Setter
    @Getter
    // min-max
    private int rangeCount = 0;

    /**
     * 函数后面的参数列表 需要删除单引号或者双引号
     */
    @Setter
    @Getter
    private String parameters = "";

    @Setter
    @Getter
    private int min = 0;

    @Setter
    @Getter
    private int max = 0;

    @Setter
    @Getter
    // min-max
    private int count = 0;

    @Setter
    @Getter
    private String[] decimal;

    @Setter
    @Getter
    private int dmin = 0;

    @Setter
    @Getter
    private int dmax = 0;

    @Setter
    @Getter
    // dmin-dimax
    private int dcount = 0;
}
