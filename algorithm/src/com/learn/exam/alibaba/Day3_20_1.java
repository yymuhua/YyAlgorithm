package com.learn.exam.alibaba;

import java.util.Scanner;

/**
 * 有一叠扑克牌，每张牌介于1和10之间
 * 有四种出牌方法：
 * 1 单出1张
 * 2 出2张对子
 * 3 出五张顺子，如12345
 * 4 出三连对子，如112233
 * 给10个数，表示1-10每种牌有几张，问最少要多少次能出完
 * 思路：dfs + 回溯
 *
 * @author yymuhua
 * @create 2020-04-13 13:04
 */
public class Day3_20_1 {
    private static int minCnt = Integer.MAX_VALUE;
    private static int[] cards = new int[10]; // 牌数记录数组

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            cards[i] = sc.nextInt();
        }
        //from:从哪个数字牌开始，count：已经出了多少次牌
        dfs(0, 0);
        System.out.println(minCnt);
    }

    /**
     * 深度优先搜索
     *
     * @param start 从牌 start 开始出牌
     * @param count 记录此时已经出了多少次牌
     */
    public static void dfs(int start, int count) {
        if (count >= minCnt) return; // 如果次数已经大于记录到的最小次数，无需再搜索
        // 牌已出完，结束搜索并更新最小出牌数
        if (start >= 10) {
            minCnt = count;
            return;
        }
        // start 牌数量为 0，从下一数字牌开始
        if (cards[start] == 0) {
            dfs(start + 1, count);
            return;
        }
        // 选择出牌方案
        // 1、出 3 连对
        if (popSixable(start)) {
            // 出牌
            popCard(start, start + 3, 2);
            // 向下一层搜索
            dfs(start, count + 1);
            // 撤销出牌
            cancel(start, start + 3, 2);
        }
        // 2、能出顺子
        if (popFiveable(start)) {
            popCard(start, start + 5, 1);
            dfs(start, count + 1);
            cancel(start, start + 5, 1);
        }
        // 3、能出对子
        if (cards[start] >= 2) {
            popCard(start, start + 1, 2);
            dfs(start, count + 1);
            cancel(start, start + 1, 2);
        }
        // 4、出单张
        popCard(start, start + 1, 1);
        dfs(start, count + 1);
        cancel(start, start + 1, 1);
    }

    // 判断能否出三连对
    public static boolean popSixable(int start) {
        if (start > 7) return false;
        return cards[start] >= 2 &&
                cards[start + 1] >= 2 &&
                cards[start + 2] >= 2;
    }

    // 判断能否出 5 张顺子
    public static boolean popFiveable(int start) {
        if (start > 5) return false;
        for (int i = start; i < start + 5; i++) {
            if (cards[i] < 1) return false;
        }
        return true;
    }

    public static void popCard(int start, int end, int count) {
        for (int i = start; i < end; i++) {
            cards[i] -= count;
        }
    }

    public static void cancel(int start, int end, int count) {
        for (int i = start; i < end; i++) {
            cards[i] += count;
        }
    }
}
