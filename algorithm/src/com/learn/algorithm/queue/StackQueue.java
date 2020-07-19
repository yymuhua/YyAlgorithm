package com.learn.algorithm.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用栈实现队列
 * 两个辅助栈实现队列
 *
 * @author yymuhua
 * @create 2020-04-20 9:56
 */
public class StackQueue {
    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.peek();
    }

    private Deque<Integer> in;
    private Deque<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public StackQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) return -1;
        if (out.isEmpty()) {
            fillOut();
        }
        return out.pop();
    }

    private void fillOut() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) return -1;
        if (out.isEmpty()) {
            fillOut();
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
