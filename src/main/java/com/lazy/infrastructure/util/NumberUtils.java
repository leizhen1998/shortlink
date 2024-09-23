package com.lazy.infrastructure.util;

public class NumberUtils {
    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String toBase62(long decimal) {
        StringBuilder base62 = new StringBuilder();
        while (decimal > 0) {
            int remainder = (int) (decimal % 62);
            base62.insert(0, BASE62_CHARS.charAt(remainder));
            decimal /= 62;
        }
        return base62.toString();
    }
}
