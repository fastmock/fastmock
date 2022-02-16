package io.github.fastmock.random;

/**
 * author wangkun23
 * version 1.0.0
 * date 2022/1/25 20:47
 */
public class RandomColor {

    public static String hex() {
        return hex(8);
    }

    public static String hex(int length) {
        char[] hexValues = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            hexString.append(hexValues[RandomBasic.nextInt(0, hexValues.length - 1)]);
        }
        return hexString.toString();
    }
}
