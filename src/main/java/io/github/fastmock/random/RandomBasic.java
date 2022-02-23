package io.github.fastmock.random;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author: wangkun32
 * date: 2021/12/28 13:36
 */
public class RandomBasic {
    private static final Random RANDOM = new Random();

    // 返回一个随机的布尔值。
    public static boolean nextBool() {
        return RANDOM.nextBoolean();
    }

    // 返回一个随机的自然数（大于等于 0 的整数）。
    public static int nextNatural(int min, int max) {
        return min == max ? min : min + RANDOM.nextInt(max - min + 1);
    }

    // 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
    public static int nextInt(int min, int max) {
        if (max == 0) {
            return RANDOM.nextInt(min + 1);
        }
        return min == max ? min : min + RANDOM.nextInt(max - min + 1);
    }

    // 返回一个随机的浮点数。
    public static BigDecimal nextFloat(int min, int max, int dmin, int dmax) {
        if (dmax == 0) {
            dmax = dmin;
        }

        int value = nextInt(min, max);
        // 保留的小数位数
        int decimal = nextInt(dmin, dmax);
        StringBuilder builder = new StringBuilder();
        builder.append(value).append(".");
        for (int i = 0; i < decimal; i++) {
            builder.append(nextInt(0, 9));
        }
        return new BigDecimal(builder.toString());
    }


    // 返回一个整型数组。
    public static List<Integer> range(int min, int max, int count) {
        int len = nextInt(0, count);
        List<Integer> range = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            int rand = nextInt(min, max);
            range.add(rand);
        }
        return range;
    }
}
