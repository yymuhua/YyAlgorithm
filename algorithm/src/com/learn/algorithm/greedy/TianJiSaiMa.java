package com.learn.algorithm.greedy;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 田忌赛马问题
 *
 * @author yymuhua
 * @create 2020-04-19 13:08
 */
public class TianJiSaiMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] tian = new int[N];
        int[] qi = new int[N];
        for (int i = 0; i < N; i++) {
            tian[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            qi[i] = sc.nextInt();
        }
        System.out.println(200 * game(N, qi, tian));
        sc.close();
    }

    /**
     * n 代表田忌和齐王分别有多少马
     * qi 代表齐王的 n 匹马的速度，齐王必定按顺序从快到慢出马
     * tian 代表田忌的 n 匹马的速度，田忌可以任意顺序出马
     * 输出：正数代表田忌赢了几局，负数代表输，平局输出0
     *
     * @param n
     * @param tian
     * @param qi
     * @return
     */
    public static int game(int n, int[] qi, int[] tian) {
        int cntWin = 0;    // 田忌净胜场
        Arrays.sort(qi);
        Arrays.sort(tian);
        int lowQi = 0;        // 齐最慢马编号
        int fastQi = n - 1;    // 齐最快马编号
        int lowTian = 0;        // 田最快马编号
        int fastTian = n - 1;    // 田最慢马编号
        for (int i = 0; i < n; i++) {
            // 总共比 n 场，从田忌最差的马开始考虑
            // 1. 如果田最慢快于齐最慢，直接比赛，胜场 +1
            if (tian[lowTian] > qi[lowQi]) {
                lowQi++;
                lowTian++;
                cntWin++;
                // 2. 如果田最慢慢于齐最慢（说明田忌这匹马一定会输），直接对掉齐最快的马，胜场 -1
            } else if (tian[lowTian] < qi[lowQi]) {
                lowTian++;
                fastQi--;
                cntWin--;
                // 3. 如果田忌最慢的马和齐王最慢的马一样快，可以平局也可以对掉，进一步考虑齐王最快的马值不值得对掉
            } else {

                // 3.1 如果田忌最快的马快于齐王最慢的马，直接比赛，胜场 +1
                if (tian[fastTian] > qi[fastQi]) {
                    fastTian--;
                    fastQi--;
                    cntWin++;
                    // 3.2 如果田忌最快的马慢于或等于齐王最快的马，直接让田忌最慢的马和齐王最快马比
                } else {
                    if (tian[lowTian] < qi[fastQi]) {
                        cntWin--;
                    }
                    lowTian++;
                    fastQi--;
                }
            }
        }
        return cntWin;
    }
}
