package com.learn.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * 单调栈
 *
 * @author yymuhua
 * @create 2020-04-11 21:47
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreatElement(new int[]{2, 1, 2, 4, 3})));
    }

    /**
     * 返回数组res：res[i] 定义为位于 nums[i] 之后的第一个大于 nums[i] 的元素
     * 暴力遍历时间复杂度O(n^2)，采用单调栈可以降为O(n)
     *
     * @param nums
     * @return
     */
    public static int[] nextGreatElement(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) == 0) return nums;
        int[] res = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        // 倒着遍历
        for (int i = N - 1; i >= 0; i--) {
            // 将stack中小于等于当前数的全部出栈
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
