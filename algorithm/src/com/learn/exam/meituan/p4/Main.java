package com.learn.exam.meituan.p4; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */
//第一行输入三个数,n,m,s代表图中的点数，边数，以及晨晨的起点的编号
//
//        接下来m行，每行3个数u,v,w描述一条无向边，代表点u到点v有一条无向边，长度为w。
//
//        接下来一行一个数k，描述晨晨希望跑的距离。

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        while (sc.hasNextInt()) {
            // get test value
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int[][] A = new int[m][m];
            int res = 0;
            // to do
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                A[u][v] = w;
                A[v][u] = w;
            }
            // BFS
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            while (!q.isEmpty()) {
                int size = q.size();

            }
            // output
            System.out.println(res);
        }
        sc.close();
    }
}
