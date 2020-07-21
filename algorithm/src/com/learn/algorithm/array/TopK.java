package com.learn.algorithm.array;

import java.util.Arrays;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/21 1:01 上午
 */
public class TopK {
    public int[] getLeastNumbers(int[] nums, int k) {
        int N;
        if (nums == null || (N = nums.length) <= k) {
            return nums;
        }
        return helper(nums, 0, N, k);
    }
    private int[] helper(int[] nums, int start, int end, int k) {
        int index = quickSearch(nums, start, end);
        if (index == k - 1) {
            return Arrays.copyOfRange(nums, 0, k);
        }
        return index > k - 1 ? helper(nums, start, index - 1, k) : helper(nums, index + 1, end, k);
    }
    private int quickSearch(int[] nums, int start, int end) {
        int aimValue = nums[start];
        // 将aimValue放到合适的位置，使其前面的所有数小于等于它，后面的数大于它
        int left = start;
        int right = end - 1;
        while (left < right) {
            // left 是空位，从right往左搜索找到第一个小于aimValue的，填入
            while (left < right && nums[right] > aimValue) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            // right 是空位，从left往右搜索填入
            while (left < right && nums[left] <= aimValue) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        // left == right
        return left;
    }

    public static void main(String[] args) {
        new TopK().getLeastNumbers(new int[]{}, 0);
    }
}
