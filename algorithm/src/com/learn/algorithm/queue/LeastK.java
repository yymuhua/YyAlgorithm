package com.learn.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yymuhua
 * @create 2020-04-19 22:39
 */
public class LeastK {
    public int shortestSubarray(int[] A, int K) {
        int N;
        if (A == null || (N = A.length) == 0) {
            return -1;
        }
        if (A[0] >= K) {
            return 1;
        }
        int[] prefixSum = new int[N]; // 前缀和
        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        int minLen = Integer.MAX_VALUE;
        boolean finded = false;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            // 找到以 A[i] 结尾的符合条件的最短子数组
            // 本质上是找最大的j < i，满足prefixSum[i] - prefixSum[j] >= K
            // 维护一个双向队列，从 first -> last 单调减
            while (!deque.isEmpty() && prefixSum[i] < prefixSum[deque.getFirst()]) {
                // 确保单调性，需要将大于当前数值的队首元素全部移出
                deque.removeFirst();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getLast()] >= K) {
                minLen = Math.min(minLen, i - deque.getLast());
                deque.removeLast();
                finded = true;
            }
            if (prefixSum[i] >= K) {
                minLen = Math.min(minLen, i + 1);
                finded = true;
            }
            deque.addFirst(i);
        }
        return finded ? minLen : -1;
    }
}
