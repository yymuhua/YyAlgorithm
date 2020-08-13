package com.learn.algorithm.math;

/**
 * 常用位操作：
 * @author yymuhua
 * @create 2020-03-12 18:38
 */
public class BitManipulation {
    public static void main(String[] args) {
        System.out.println(toLowerCase('A'));
        System.out.println(toUpperCase('a'));
        System.out.println(swapCase('a'));
        System.out.println(swapCase('A'));
        System.out.println(getSum(13, 43));
    }
    /**
     * 大写字符转小写：或运算空格字符 => ('A' | ' ') = 'a'
     */
    public static char toLowerCase(char c) {
        return (char) (c | ' ');
    }

    /**
     * 小写字符转大写：与运算下划线字符 => ('a' | '_') = 'A'
     */
    public static char toUpperCase(char c) {
        return (char) (c & '_');
    }

    /**
     * 大小写互换：异或运算空格字符 => ('a' ^ ' ') = 'A', ('A' ^ ' ') = 'a'
     */
    public static char swapCase(char c) {
        return (char) (c ^ ' ');
    }

    /**
     * 判断两个数是否为异号
     */
    public static boolean isSameSignal(int a, int b) {
        return (a ^ b) < 0;
    }

    /**
     * 对num的bit为取反
     */
    public static int changeBit(int num, int bit) {
        return ((1 << bit) ^ num);
    }

    /**
     * 判断num的bit位是否为0
     */
    public static boolean isBitZero(int num, int bit) {
        return ((1 << bit) & num) == 0;
    }
    /**
     * 采用位运算进行加法
     */
    public static int getSum(int a, int b) {

        while(a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        // a & b == 0，不存在进位，异或运算即为和运算
        return b;
    }

    /**
     * 消除数字num二进制表示中最右边的1
     */
    public static int removeLastBit1(int num) {
        return num & (num - 1);
    }

    /**
     * 仅保留数字num二进制表示中最右边的1
     */
    public static int keepLastBit1(int num) {
        return num & (-num);
    }
}
