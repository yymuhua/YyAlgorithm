package com.learn.algorithm.greedy;

/**
 * LeetCode 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/29 7:27 下午
 */
public class MinSwapsCouples {
    public int minSwapsCouples(int[] row) {
        int N = row.length;
        int res = 0;
        // 每次都为座位左半边的人找到他的情侣，放到座位右半边
        // x 的情侣为 x ^ 1
        for (int i = 0; i < N; i += 2) {
            int x = row[i];
            if (row[i + 1] != (x ^ 1)) {
                res++;
                for (int j = i + 2; j < N; j++) {
                    if (row[j] == (x ^ 1)) {
                        row[j] = row[i + 1];
                        row[i + 1] = x ^ 1;
                        break ;
                    }
                }
            }
        }
        return res;
    }
}
