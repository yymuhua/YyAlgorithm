package com.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yymuhua
 * @create 2020-04-20 10:31
 */
public class MaxStack {
    private Deque<Integer> d;
    private Deque<Integer> max;
    /** initialize your data structure here. */
    public MaxStack() {
        d = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public void push(int x) {
        d.push(x);
        if(max.isEmpty() || max.peek() <= x) {
            max.push(x);
        }
    }

    public int pop() {
        int res = d.pop();
        if(max.peek() == res) {
            max.pop();
        }
        return res;
    }

    public int top() {
        if(d.isEmpty()) return -1;
        return d.peek();
    }

    public int peekMax() {
        if(max.isEmpty()) return -1;
        return max.peek();
    }

    public int popMax() {
        Queue<Integer> q = new LinkedList<>();
        while(d.peek() != max.peek()) {
            q.add(d.pop());
        }
        d.pop();
        int res = max.pop();
        while(!q.isEmpty()) {
            push(q.remove());
        }
        return res;
    }
}

