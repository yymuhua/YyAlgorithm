package com.learn.algorithm.array;

/**
 * 顺时针螺旋打印矩阵
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/29 12:06 下午
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] nums) {
        int N, M;
        if(nums == null || (N = nums.length) == 0 || (M = nums[0].length) == 0) {
            return new int[] {};
        }
        // 对应顺时针顺序
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int[] xBound = new int[] {0, N - 1};
        int[] yBound = new int[] {0, M - 1};
        int x = 0;
        int y = -1;
        int dir = 0;
        int[] res = new int[N * M];
        int idx = 0;
        while (idx < M * N) {
            if (!onBoard(x + dx[dir], xBound, y + dy[dir], yBound)) {
                switch (dir) {
                    case 0 : {
                        xBound[0]++;
                        break ;
                    }
                    case 1 : {
                        yBound[1]--;
                        break ;
                    }
                    case 2 : {
                        xBound[1]--;
                        break ;
                    }
                    default : {
                        yBound[0]++;
                    }
                }
                dir = (1 + dir) % 4;
            }
            x += dx[dir];
            y += dy[dir];
            res[idx] = nums[x][y];
            idx++;
        }
        return res;
    }
    private boolean onBoard(int x, int[] xBound, int y, int[] yBound) {
        return x >= xBound[0] && x <= xBound[1] && y >= yBound[0] && y <= yBound[1];
    }
}
