package com.learn.algorithm.greedy;

/**
 * LeetCode 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果;
 *      1. 每个孩子至少分配到 1 个糖果。
 *      2. 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/29 10:08 上午
 */
public class Candy {
    public int candy(int[] ratings) {
        int N = 0;
        if (ratings == null || (N = ratings.length) <= 1) {
            return N;
        }
        // candy[i] 代表 i 号孩子能获取的糖果数量
        int[] candy = new int[N];
        // 从左到右遍历，如果大于左邻居则糖果数 + 1
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // 从右到左遍历，如果大于右邻居，则糖果数 + 1
        // 注：此时需要先判断是否已经满足大于右邻居这个条件，如果已经大于则没必要 + 1
        int cnt = candy[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
            cnt += candy[i];
        }
        // 每人至少一颗糖，因此每人多发一颗
        return cnt + N;
    }
}
