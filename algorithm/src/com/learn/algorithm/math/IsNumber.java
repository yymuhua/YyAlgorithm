package com.learn.algorithm.math;

/**
 * 有效的表示数字的字符串
 *
 * @author yymuhua
 * @create 2020-04-19 15:45
 */
public class IsNumber {
    /**
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串".3"、"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        // 规则：+-符号前面不允许有其他字符
        boolean hasNum = false;
        boolean hasDot = false;
        boolean hasE = false;
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                hasNum = true;
            } else if (c == '.') {
                // '.' 之前不允许出现 'e' 和 '.'
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (c == 'e' || c == 'E') {
                // 'e' 之前不允许出现 'e' 且必须出现数字
                if (hasE || !hasNum) return false;
                hasE = true;
                hasNum = false; // 重置hasNum，确保'e'之后必须有数字
            } else if (c == '+' || c == '-') {
                // 正负号必须出现在开头或者紧跟在e的后面
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') return false;
            } else return false;
        }
        return hasNum; // 所有有效数字必须以数字结尾
    }
}
