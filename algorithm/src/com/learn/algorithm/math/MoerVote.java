package com.learn.algorithm.math;

/**
 * 摩尔投票法
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/19 9:24 下午
 */
public class MoerVote {
    /**
     * 剑指 Offer 39. 数组中出现次数超过一半的数字
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
            }
            cnt += nums[i] == res ? 1 : -1;
        }
        return res;
    }
}
