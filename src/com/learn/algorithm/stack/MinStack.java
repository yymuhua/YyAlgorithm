package com.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单调栈问题
 * @author yymuhua
 * @create 2020-04-09 21:42
 */
public class MinStack {
    /**
     * LeetCode84. 计算柱状图中最大的矩形面积
     * @param A
     * @return
     */
    public int largestRectangleArea(int[] A) {
        int N;
        if(A == null || (N = A.length) == 0) return 0;
        int res = 0;

        int[] newHeights = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            newHeights[i] = A[i - 1];
        }
        // 放入两个哨兵
        newHeights[0] = 0; // 确保栈中始终不为空
        newHeights[N + 1] = 0; // 确保高度最低的柱形对应面积也能被计算出来
        A = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(N + 2);
        stack.push(0);

        for (int i = 1; i < N + 2; i++) {
            // 找到栈中全部大于当前高度的柱形（可以确定以其高度组成的最大面积）
            while (A[i] < A[stack.element()]) {
                int currHeight = A[stack.remove()];
                int currWidth = i - stack.element() - 1;
                res = Math.max(res, currHeight * currWidth);
            }
            stack.push(i);
        }
        return res;
    }

}
