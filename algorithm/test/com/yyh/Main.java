package com.yyh;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        // 对应逆时针顺序
        int[] dx = new int[] {1, 0, -1, 0};
        int[] dy = new int[] {0, 1, 0, -1};
        int[] xBound = new int[] {0, N - 1};
        int[] yBound = new int[] {0, M - 1};
        int x = 0;
        int y = 0;
        int dir = 0;
        System.out.print(nums[x][y] + " ");
        int cnt = 1;
        while (cnt < M * N) {
            if (!onBoard(x + dx[dir], xBound, y + dy[dir], yBound)) {
                switch (dir) {
                    case 0 : {
                        yBound[0]++;
                        break ;
                    }
                    case 1 : {
                        xBound[1]--;
                        break ;
                    }
                    case 2 : {
                        yBound[1]--;
                        break ;
                    }
                    default : {
                        xBound[0]++;
                    }
                }
                dir = (1 + dir) % 4;
            }
            x += dx[dir];
            y += dy[dir];
            System.out.print(nums[x][y] + " ");
            cnt++;
        }
        sc.close();
    }
    private static boolean onBoard(int x, int[] xBound, int y, int[] yBound) {
        return x >= xBound[0] && x <= xBound[1] && y >= yBound[0] && y <= yBound[1];
    }
}
