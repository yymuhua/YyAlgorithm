package com.learn.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 矩阵中的最小路径和
 *
 * @author yymuhua
 * @create 2020-03-28 12:06
 */
public class MinPathSum {
    public static int minPathSum(int[][] nums) {
        int M, N;
        if (nums == null || (M = nums.length) == 0 || (N = nums[0].length) == 0) {
            return 0;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i != 0 && j != 0) {
                    int adder = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        adder = Math.min(adder, nums[i - 1][j]);
                    }
                    if (j - 1 >= 0) {
                        adder = Math.min(adder, nums[i][j - 1]);
                    }
                    nums[i][j] += adder;
                }
            }
        }
        return nums[M - 1][N - 1];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][] {{1, 2},{1, 1}};
        System.out.println(Arrays.deepToString(nums));
        System.out.println(minPathSum(nums));
    }
}
