package com.learn.algorithm.array;

import java.util.*;

/**
 * N数之和问题
 *
 * @author yymuhua
 * @create 2020-04-10 13:18
 */
public class NSum {
    /**
     * 两数之和问题，找出任意一个符合条件的数据对对应的下标
     *
     * @param nums
     * @param target
     * @return 数据对的下标
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        // HashMap解法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = map.get(target - nums[i]);
                if (i != j) {
                    return new int[]{i, j};
                }
            }
            // 重复的nums[i] 直接覆盖即可，因为从前往后搜索
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 两数之和问题，双指针解法（返回所有符合条件的数据对）
     *
     * @param nums
     * @param target
     * @return 所有数据对
     */
    public List<int[]> twoSum1(int[] nums, int target) {
        int N;
        List<int[]> res = new ArrayList<>();
        if (nums == null || (N = nums.length) <= 2) {
            return res;
        }
        // 先对数组排序
        Arrays.sort(nums);
        int left = 0;
        int right = N - 1;
        while (left < right) {
            if (2 * nums[left] > target || 2 * nums[right] < target) {
                // 提前判断剩余部分不可能包含符合条件的数据对
                break;
            }
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(new int[]{nums[left], nums[right]});
            }
            if (sum >= target) {
                // 找到下一个right，注意需要去重
                int temp = right;
                while (temp > left && nums[temp] == nums[right]) {
                    temp--;
                }
                right = temp;
            }
            if (sum <= target) {
                int temp = left;
                while (temp < right && nums[temp] == nums[left]) {
                    temp++;
                }
                left = temp;
            }
        }
        return res;
    }

    /**
     * 三数之和问题
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int N;
        if (nums == null || (N = nums.length) <= 2) {
            return res;
        }
        // 排序 + 双指针 + 去重
        Arrays.sort(nums);
        for (int i = 0; i < N - 2; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            int target = -nums[i];
            // 退化为两数之和问题
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * 四数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int N;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || (N = nums.length) <= 3) {
            return res;
        }
        Arrays.sort(nums);

        // 先确定两个数组，将规模缩小为两数之和问题，然后再用双指针问题求解
        for (int a = 0; a < N - 3; a++) {
            // 去重
            if (a != 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < N - 2; b++) {
                if (b != a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                int aim = target - (nums[a] + nums[b]);

                // 采用双指针搜索
                int left = b + 1;
                int right = N - 1;
                while (left < right) {
                    // 快速判断子数组中是否一定不存在数据对
                    if (2 * nums[left] > aim || 2 * nums[right] < aim) {
                        break;
                    }
                    int sum = nums[left] + nums[right];
                    if (sum == aim) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                    }
                    if (sum >= aim) {
                        // 寻找下一个right
                        int temp = right;
                        while (temp > left && nums[temp] == nums[right]) {
                            temp--;
                        }
                        right = temp;
                    }
                    if (sum <= aim) {
                        // 寻找下一个left
                        int temp = left;
                        while (temp < right && nums[temp] == nums[left]) {
                            temp++;
                        }
                        left = temp;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 找出和为k的所有子数组个数
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int N;
        int res = 0;
        if (nums == null || (N = nums.length) == 0) {
            return res;
        }
        // 键值对表示前缀和为key的子数组数量为value
        Map<Integer, Integer> prefixSum = new HashMap<>(N);
        prefixSum.put(0, 1); // 确保长度为1的子数组能被筛选出来
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            if (prefixSum.containsKey(sum - k)) {
                res += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
