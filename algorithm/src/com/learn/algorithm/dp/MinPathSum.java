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
        for (int i = 1; i < M; i++) {
            nums[i][0] += nums[i - 1][0];
        }
        for (int j = 1; j < N; j++) {
            nums[0][j] += nums[0][j - 1];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                nums[i][j] += Math.min(nums[i - 1][j], nums[i][j - 1]);
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
