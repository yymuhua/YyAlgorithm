package com.learn.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-12 17:35
 */
public class KthPermutation {
    /**
     * LeetCode 60. 第k个排列
     * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。(n <= 9)
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     *  "123"
     *  "132"
     *  "213"
     *  "231"
     *  "312"
     *  "321"
     * 返回第 k 个排列
     */
    class Solution {
        int[] facts;
        public String getPermutation(int n, int k) {
            facts = new int[n + 1]; // facts[i] = i!
            facts[0] = 1;
            List<Integer> list = new ArrayList<>(); // 存放可以使用的数字（字典序升序排列）
            for(int i = 1; i <= n; i++) {
                facts[i] = facts[i - 1] * i;
                list.add(i);
            }
            return helper(list, k - 1);
        }
        private String helper(List<Integer> list, int k) {
            int N;
            if(list == null || (N = list.size()) == 0) return "";
            int index = k / facts[N - 1];
            String head = "" + list.get(index);
            list.remove(index);
            return head + helper(list, k % facts[N - 1]);

        }
    }
}
