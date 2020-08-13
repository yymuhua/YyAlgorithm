package com.learn.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调队列：从队头到队尾单调递减，用于动态获取区间的最大值
 * 目标为获取变化区间的最大值，并没有存储整个区间的全部内容
 * @author yymuhua
 * @create 2020-04-13 15:38
 */
public class MonotonicQueue {
    Deque<Integer> deque;
    public MonotonicQueue() {
        deque = new ArrayDeque<>();
    }
    // 在队尾添加元素 n
    void push(int n) {
        // 将尾部全部小于 n 的元素删除，确保整体的单调性
        while(!deque.isEmpty() && deque.getLast() < n) {
            deque.removeLast();
        }
        deque.addLast(n);
    }
    // 返回当前队列中的最⼤值
    int max() {
        if(deque.isEmpty()) return -1;
        return deque.getFirst();
    }
    // 队头元素如果是 n， 删除它（只能按照入队顺序FIFO地删除，不能随机删除）
    void pop(int n) {
        if(!deque.isEmpty() && deque.getFirst() == n) {
            deque.removeFirst();
        }
    }
}
