package com.learn.algorithm.array;

/**
 * 螺旋矩阵
 * @author yymuhua
 * @create 2020-04-09 12:30
 */
public class SpiralMatrix {
    /**
     * 构造螺旋矩阵，将1:n2填入
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int end = n * n;
        int x = 0;
        int y = 0;
        int dir = 0;
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        int[] xBound = new int[] {0, n - 1};
        int[] yBound = new int[] {0, n - 1};
        for(int i = 1; i <= end; i++) {
            if(!onBoard(x, y, xBound, yBound)) {
                switch(dir) {
                    case 0: {
                        x = ++xBound[0];
                        y = yBound[1];
                        dir = 1;
                        break;
                    }
                    case 1: {
                        x = xBound[1];
                        y = --yBound[1];
                        dir = 2;
                        break;
                    }
                    case 2: {
                        x = --xBound[1];
                        y = yBound[0];
                        dir = 3;
                        break;
                    }
                    case 3: {
                        x = xBound[0];
                        y = ++yBound[0];
                        dir = 0;
                        break;
                    }
                }

            }
            res[x][y] = i;
            x += dx[dir];
            y += dy[dir];
        }
        return res;
    }
    private static boolean onBoard(int x, int y, int[] xBound, int[] yBound) {
        return x >= xBound[0] && x <= xBound[1]
                && y >= yBound[0] && y <= yBound[1];
    }
}
