package com.learn.algorithm.greedy;

import java.util.Arrays;

/**
 * 相交区间问题（区间调度问题）：
 * 给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
 * 具体应用场合：比如活动用[开始时间，结束时间]表示，问最多能参加多少个活动？
 * LeetCode相关题目：435，452
 *
 * @author yymuhua
 * @create 2020-03-27 19:56
 */
public class Intvs {
    /**
     * 求 intvs 中最大不相区间的数目
     * 具体思路：
     * 1. 从区间集合 intvs 中选择一个区间 x，这个 x 是在当前所有区间中结束最早的（end 最小），可以先按end升序排列！
     * 2. 把所有与 x 区间相交的区间从区间集合 intvs 中删除。
     * 3. 重复步骤 1 和 2，直到 intvs 为空为止。之前选出的那些 x 就是最大不相交子集。
     *
     * @param intvs
     * @return
     */
    public static int intervalSchedule(int[][] intvs) {
        if (intvs == null || intvs.length <= 0) return 0;
        Arrays.sort(intvs, (a, b) -> a[1] - b[1]);
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] intv : intvs) {
            int start = intv[0];
            // 跳过所有与 x 相交的区间
            // 按 end 排序之后，intv 区间与 x 区间相交的条件：intv[0] <  x_end
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = intv[1];
            }
        }
        return count;
    }
}
