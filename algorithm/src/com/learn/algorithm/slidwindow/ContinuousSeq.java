package com.learn.algorithm.slidwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/19 8:37 下午
 */
public class ContinuousSeq {
    /**
     * 剑指 Offer 57 - II. 和为s的连续正数序列
     *      输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        List<int[]> list = new ArrayList<>();
        int sum = 1;
        while (right <= (target >> 1) + 1) {
            if (sum == target && right > left) {
                int[] nums = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    nums[i - left] = i;
                }
                list.add(nums);
            }
            // 窗口中数值过大，从左侧缩小
            if (sum >= target) {
                sum -= left;
                left++;
            // 窗口中数值过小，从右侧扩大
            } else {
                right++;
                sum += right;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
