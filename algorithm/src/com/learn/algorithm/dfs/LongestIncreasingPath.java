package com.learn.algorithm.dfs;

/**
 * 矩阵的最长递增路径
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/26 11:11 下午
 */
public class LongestIncreasingPath {
    private int[] dy = new int[] {-1, 1, 0, 0};
    private int[] dx = new int[] {0, 0, -1, 1};
    private int[][] matrix;
    private int[][] memo;
    private int M;
    private int N;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || (M = matrix.length) == 0 || (N = matrix[0].length) == 0) {
            return 0;
        }
        this.matrix = matrix;
        memo = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return  res;
    }
    private int dfs(int x, int y) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        memo[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (onBoard(newX, newY) && matrix[newX][newY] > matrix[x][y]) {
                memo[x][y] = Math.max(memo[x][y], dfs(newX, newY) + 1);
            }
        }
        return memo[x][y];
    }
    private boolean onBoard(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }
}
