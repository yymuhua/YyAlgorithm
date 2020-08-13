package com.learn.algorithm.array;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/8/7 4:39 下午
 */
public class RainWater {
    /**
     * LeetCode 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int N;
        if (height == null || (N = height.length) <= 1) {
            return 0;
        }
        // 从两边向中间搜索，记录左边和右边的最大值
        // 左边使用左边最大值，右边使用右边最大值
        // 需要从小的一方向大的一方搜索 <= 如果递增
        int left = 0;
        int right = N - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
