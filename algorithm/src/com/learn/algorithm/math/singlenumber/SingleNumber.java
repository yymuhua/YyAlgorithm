package com.learn.algorithm.math.singlenumber;

/**
 * 只出现一次的数字
 *
 * @author yymuhua
 * @create 2020-04-19 18:30
 */
public class SingleNumber {
    /**
     * LeetCode 136. 非空数组除了某个数字出现了一次，其他数字均出现了两次
     * 求这个只出现了一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    /**
     * LeetCode 137. 非空数组除了某个数字出现了一次，其他数字均出现了三次，求这个只出现了一次的数字
     * 思路：采用位计数的思想，对所有数字的第 i 位进行计数。
     * 出现了三次的数无论第 i 位是 0 还是 1，sum % 3 == 0
     * 因此 sum % 3 的结果仅有只出现了一次的数第 i 位决定
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int res = 0;
        // 位计数
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1;
            }
            if (sum % 3 != 0) res |= (1 << i);
        }
        return res;
    }

    /**
     * LeetCode 260. 非空数组恰好有两个数组只出现了一次，其他的都出现了两次。求这两个数字
     * 思路：按照LeetCode 136的思路，如果能将这两个数字分别分到两个数组中，就可以解决。
     *
     * @param nums
     * @return
     */
    public int[] singleNumber3(int[] nums) {
        int N = nums.length;
        int bit = 0;
        for (int num : nums) {
            bit ^= num;
        }
        // bit = x ^ y，其中最右边的 1 一定要么来自 x 要么来自 y
        int mask = bit & (-bit); // 将只包含最右边一位1的数字作为掩码，用于将nums分为两组
        int x = 0; // 假设这一位1来自于x
        int y = 0;
        for (int num : nums) {
            if ((num & mask) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
