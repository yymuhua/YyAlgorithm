package com.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 验证有效的栈序列
 * @author yymuhua
 * @create 2020-04-20 10:41
 */
public class ValidStackSeq {
    /**
     * LeetCode 946. 验证栈序列
     * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
     * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> d = new ArrayDeque<>();
        int idx = 0;
        for(int push : pushed) {
            d.push(push);
            while(!d.isEmpty() && d.peek() == popped[idx]) {
                d.pop();
                idx++;
            }
        }
        return idx == popped.length;
    }
}
