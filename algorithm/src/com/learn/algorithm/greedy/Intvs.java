package com.learn.algorithm.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

    /**
     * LeetCode 253. 会议室2
     * intvs 代表 N 场会议，intvs[i][0]代表i会议的开始时间，intvs[i][1]代表i会议的结束时间
     * 求问：至少需要多少间会议室才能安排所有的会议
     * @param intvs
     * @return
     */
    public int minMeetingRooms(int[][] intvs) {
        int N;
        if(intvs == null || (N = intvs.length) == 0)
            return 0;
        // 所有会议按开始时间排序
        Arrays.sort(intvs, (interval1, interval2) -> interval1[0] - interval2[0]);
        // 放房间中当前会议的结束时间（按结束时间排序）
        Queue<Integer> rooms = new PriorityQueue<>();
        rooms.add(intvs[0][1]);
        for(int i = 1; i < N; i++) {
            // 碰到一个会议，判断会议室结束时间最早的能否使用，如果能则直接使用，如果不能，则需要新增一个会议室
            int roomEnd = rooms.element();
            if (roomEnd <= intvs[i][0]) {
                rooms.remove();
            }
            rooms.add(intvs[i][1]);
        }
        return rooms.size();
    }

    /**
     * LeetCode 1326. 灌溉花园的最少水龙头数目
     * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
     * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
     * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，
     * 其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
     * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
     * @param n
     * @param ranges
     * @return
     */
    // => 求覆盖区间的最少小区间数量
    public static int minTaps(int n, int[] ranges) {
        // 从 0 出发最少换多少个区间能到达 n, 与跳跃游戏2解法类似
        // 按开始时间排序
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i <= n; i++) {
            if (ranges[i] != 0) {
                heap.add(new int[] {i - ranges[i], i + ranges[i]});
            }
        }
        int cnt = 0;
        int range = 0;
        while (!heap.isEmpty()) {
            // 找与range直线相交的区间，更新range
            int newRange = range;
            while (!heap.isEmpty() && heap.element()[0] <= range) {
                int[] tap = heap.remove();
                newRange = Math.max(newRange, tap[1]);
            }
            cnt++;
            if (newRange == range) {
                return -1;
            } else if (newRange >= n) {
                return cnt;
            }
            range = newRange;
        }
        return -1;
    }

    public static void main(String[] args) {
        minTaps(5, new int[] {3, 4, 1, 1, 0, 0});
    }
}
