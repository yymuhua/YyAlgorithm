package com.yyh;

import com.learn.algorithm.*;

import java.util.*;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 12:37 上午
 */
public class Solution {
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
                newRange = Math.max(newRange, start + nums[i]);
            }
            range = newRange;
            start = range;
            cnt++;
        }
        return cnt;
    }
}
