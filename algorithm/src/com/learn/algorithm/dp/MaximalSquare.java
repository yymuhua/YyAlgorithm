package com.learn.algorithm.dp;

/**
 * 矩形中的最大正方形面积：
 * 矩形元素为0或1，求矩形中的最大正方形的面积
 *
 * @author yymuhua
 * @create 2020-03-29 15:52
 */
public class MaximalSquare {
    /**
     * 改造原数组：A[i][j] 表示以i, j位置为正方形右下角的正方形的边长
     * A[i][j] 只需要在原本就为1的位置进行修改，如果原本为0肯定不能为正方形的右下角。
     * 确定A[i][j]只需要确定其左边、上边和左上三个元素。
     * 三个元素如果相等，那么边长+1，如果不等则A[i][j]为三个中的最小值+1
     * 0 1 1 1         0 1 1 1
     * 0 1 1 1   ===>  0 1 2 2
     * 0 1 1 1         0 1 2 3
     *
     * @param A
     * @return
     */
    public int maximalSquare(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int N = A.length;
        int M = A[0].length;
        int res = 0; // 代表正方形的边长
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    if (i > 0 && j > 0) {
                        int left = A[i][j - 1];
                        int up = A[i - 1][j];
                        int leftUp = A[i - 1][j - 1];
                        A[i][j] = 1 + Math.min(leftUp, Math.min(left, up));
                        res = Math.max(res, A[i][j]);
                    } else {
                        res = Math.max(res, 1);
                    }
                }
            }
        }
        return res * res;
    }
}
