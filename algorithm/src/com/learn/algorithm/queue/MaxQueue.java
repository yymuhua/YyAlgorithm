package com.learn.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值
 * （维护一个单调的双端队列）
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/24 7:05 下午
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> maxDeque;
    public MaxQueue() {
        queue = new LinkedList<>();
        maxDeque = new ArrayDeque<>();
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return maxDeque.getLast();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!maxDeque.isEmpty() && maxDeque.getFirst() < value) {
            maxDeque.removeFirst();
        }
        maxDeque.addFirst(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int value = queue.remove();
        if (maxDeque.getLast() == value) {
            maxDeque.removeLast();
        }
        return value;
    }
}
