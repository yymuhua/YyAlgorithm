package com.learn.algorithm.greedy;

/**
 * LeetCode 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/28 10:13 下午
 */
public class RemoveKdigits {
    /**
     * 两个位数相同的数，大小关系取决于从高位到低位第一个不相同的数的大小关系
     * 如：123a456 和 123b456 的大小关系取决于 a b 的大小关系
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        int N;
        if (num == null || (N = num.length()) <= k) {
            return "0";
        }
        // 从左到右遍历
        // 每次删掉一个数，后面的数会补上，因此只要确保后面的数小于当前数，剩余的数一定是最小的
        // 如果遍历完之后也没找到这样的数，那就删掉末尾元素
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int index = 0;
            while (index < sb.length() - 1 && sb.charAt(index) <= sb.charAt(index + 1)) {
                index++;
            }
            sb.deleteCharAt(index);
        }
        // 去除前导0，至少留一个
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
