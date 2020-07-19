package com.learn.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的指针策略
 *
 * @author yymuhua
 * @create 2020-03-13 22:33
 */
public class Pointer {
}

class Solution {
    /**
     * 三数之和：找出数组中不重复的所有三元组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        // 遍历所有非正数
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 跳过重复的数
            if (i == 0 || (i != 0 && nums[i] != nums[i - 1])) {
                // 采用双指针将问题转换为两数之和的规模
                int preLeft = -1;
                int left = i + 1;
                int preRight = nums.length;
                int right = nums.length - 1;
                int target = -nums[i];
                while (left < right) {
                    // 去重
                    if (preLeft >= 0 && nums[preLeft] == nums[left]) {
                        preLeft = left;
                        left++;
                        continue;
                    }
                    if (preRight < nums.length && nums[preRight] == nums[right]) {
                        preRight = right;
                        right--;
                        continue;
                    }

                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        list.add(l);
                        preLeft = left;
                        left++;
                        preRight = right;
                        right--;
                    } else if (sum < target) {
                        preLeft = left;
                        left++;
                    } else {
                        preRight = right;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}