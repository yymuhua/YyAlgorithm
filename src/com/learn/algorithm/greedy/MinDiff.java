package com.learn.algorithm.greedy;

import java.util.Arrays;

/**
 * 最小差值
 * @author yymuhua
 * @create 2020-04-12 14:06
 */
public class MinDiff {
    /**
     * LeetCode 910. 最小差值 II
     * 需要对数组 A 的所有元素 +K 或 -K ，返回操作之和数组中最大值与最小值之差的最小值
     * 实例：
     *      输入：A = [1,3,6], K = 3
     *      输出：3
     *      解释：B = [4,6,3]
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII(int[] A, int K) {
        int N;
        if(A == null || (N = A.length) == 0) return 0;
        // 目标：让数组具有最大的 min 和最小的 max
        //       从某个 i 位置将 A 分割为两部分，i 之前的均+K，i之后的均-K
        Arrays.sort(A);
        int res = A[N - 1] - A[0]; // 初始情况，不分割
        for(int i = 0; i < N - 1; i++) {
            int max = Math.max(A[i] + K, A[N - 1] - K);
            int min = Math.min(A[0] + K, A[i + 1] - K);
            res = Math.min(max - min, res);
        }
        return res;
    }

    /**
     * LeetCode 134. 加油站
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * 条件：如果题目有解那么解唯一
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N;
        if(gas == null || (N = gas.length) == 0) return -1;
        // remain 代表剩余油量，一次遍历找到最小的剩余油量，作为汽车的终点前一站
        int minRemain = Integer.MAX_VALUE; // 最小贡献
        int remain = 0;
        int end = 0;
        for(int i = 0; i < N; i++) {
            remain += gas[i] - cost[i];
            if(remain < minRemain) {
                minRemain = remain;
                end = i;
            }
        }
        return remain < 0 ? -1 : (end + 1) % N;
    }

    /**
     * LeetCode 135. 分发糖果
     * 规则1：每个孩子至少分配到 1 个糖果。
     * 规则2：相邻的孩子中，评分高的孩子必须获得更多的糖果，评分相同则无限制
     * 思路：
     *      考虑小孩 A 和小孩 B，小孩 A 位于小孩 B 左侧
     *      约束1：如果小孩A评分小于小孩B，小孩B的评分应该大于小孩A，从左到右遍历并用一个left数组记录
     *      约束2：如果小孩B评分大于小孩A，小孩A的评分应该大于小孩B，从右到左遍历并用一个right数组记录
     *      left[i] 和 right[i] 取其大者将同时满足约束1和约束2
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int N;
        if(ratings == null || (N = ratings.length) == 0) return 0;
        int[] left = new int[N];
        int[] right = new int[N];
        // 从左到右遍历，后者如果评分大于前者则比前者多一颗糖果
        for(int i = 1; i < N; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 从右往左遍历，前者如果评分大于后者则比后者多一颗糖果
        for(int i = N - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int res = 0;
        for(int i = 0; i < N; i++) {
            // 两者中取大者，+1 是因为每个孩子至少分到一个糖果
            res += Math.max(left[i], right[i]) + 1;
        }
        return res;
    }
}
