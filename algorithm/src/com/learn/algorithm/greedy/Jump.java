package com.learn.algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 跳跃游戏
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/29 1:31 上午
 */
public class Jump {
    /**
     * LeetCode 55. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断能否到底最后的位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) == 0) {
            return false;
        }
        int maxPos = nums[0];
        int pos = 0;
        while (pos <= maxPos && pos < N) {
            maxPos = Math.max(maxPos, nums[pos] + pos);
            pos++;
        }
        return maxPos >= N - 1;
    }

    /**
     * LeetCode 45. 跳跃游戏 II
     * 给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        // 每次都跳到区间里可达最远的点
        int N;
        if (nums == null || (N = nums.length) <= 1) {
            return 0;
        }
        int start = 0;
        int range = nums[0];
        int cnt = 1;
        while (range < N - 1) {
            int newRange = range;
            for (int i = start; i <= range; i++) {
                newRange = Math.max(newRange, i + nums[i]);
            }
            start = range;
            range = newRange;
            cnt++;
        }
        return cnt;
    }
}
