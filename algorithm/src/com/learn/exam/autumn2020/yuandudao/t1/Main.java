package com.learn.exam.autumn2020.yuandudao.t1;
/**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] classes = new int[N][2];
        for (int i = 0; i < N; i++) {
            classes[i][0] = sc.nextInt();
            classes[i][1] = sc.nextInt();
        }
        System.out.println(minMinds(classes, N));
        sc.close();
    }
    public static int minMinds(int[][] classes, int N) {
        // 所有课程按开始时间排序
        Arrays.sort(classes, (interval1, interval2) -> interval1[0] - interval2[0]);
        // 放当前mind中当前课程的结束时间（按结束时间排序）
        Queue<Integer> minds = new PriorityQueue<>();
        minds.add(classes[0][1]);
        for(int i = 1; i < N; i++) {
            // 碰到一个课程，判断mind结束时间最早的能否使用，如果能则直接使用，如果不能，则需要新增一个mind
            int mindEnd = minds.element();
            if (mindEnd <= classes[i][0]) {
                minds.remove();
            }
            minds.add(classes[i][1]);
        }
        return minds.size();
    }
}
