package com.learn.algorithm.array;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author yymuhua
 * @create 2020-04-07 11:48
 */
public class NextPermutation {
    /**
     * 修改nums为字典序更大的下一个排列，如果不存在则返回字典序最小的下一个排列
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) return;
        // 1. 从后往前搜索，找到 nums[i - 1] < nums[i] 的数据对
        int i = N - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) {
                // 2. 找到nums[i] 到 nums[N - 1] 中大于 nums[i - 1] 的最小值
                //    将 nums[i - 1] 与之交换
                int j = i;
                while (j < N && nums[j] > nums[i - 1]) {
                    j++;
                }
                j--;
                swap(nums, i - 1, j);
                break;
            }
            i--;
        }
        // 3. 将 nums[i] 到 nums[N - 1] 左右镜像，得到上升序列
        int left = i;
        int right = N - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * 前一个排列
     * @param nums
     */
    public static void prePermutation(int[] nums) {
        int N;
        if (nums == null || (N = nums.length) <= 1) return;
        int bound = N - 1; // 分界点，bound - 1 之前的部分保持不变，bound - 1位置变为下一个更小的数字

        while (bound > 0) {
            // 找到 bound 位置
            if (nums[bound] < nums[bound - 1]) {
                // 从bound开始搜索，找到小于nums[bound - 1]的最大数字
                int idx = bound;
                while (idx < N && nums[idx] < nums[bound - 1]) {
                    idx++;
                }
                idx--;
                swap(nums, bound - 1, idx);
                break;
            }
            bound--;
        }
        // bound 到 N - 1 调整为降序序列
        int left = bound;
        int right = N - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 5, 3, 1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(a));
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
        prePermutation(a);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
