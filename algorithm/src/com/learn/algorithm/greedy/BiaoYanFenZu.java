package com.learn.algorithm.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 表演分组：nums[i]中下标i代表角色编号，nums[i]数值代表饰演该角色的人数，三个不同的角色可以组成一个表演小组
 * 给一个nums求其可以组成的最多表演小组
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/28 4:37 下午
 */
public class BiaoYanFenZu {
    /**
     * 思路：贪心 + 大顶堆，按大到小的优先级进行分组
     * @param nums 各角色饰演的人数
     * @return
     */
    public static int performanceGroup(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            if (num != 0) {
                heap.add(num);
            }
        }
        int res = 0;
        while (heap.size() >= 3) {
            int a = heap.remove();
            int b = heap.remove();
            int c = heap.remove();
            if (a > 1) {
                heap.add(a - 1);
            }
            if (b > 1) {
                heap.add(b - 1);
            }
            if (c > 1) {
                heap.add(c - 1);
            }
            res++;
        }
        return res;
    }
}
