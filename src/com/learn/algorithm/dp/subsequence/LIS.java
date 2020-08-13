package com.learn.algorithm.dp.subsequence;

/**
 * 最长递增子序列问题
 * @author yymuhua
 * @create 2020-03-27 10:10
 */
public class LIS {
    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 最长递增子序列的长度
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = 1;
        int N = nums.length;
        int[] dp = new int[N]; // dp[i] 表示以 nums[i] 结尾的最长递增子序列长度
        // 每次确定 dp[i]
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            // 需要遍历 0->i 才能确定 dp[i]
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            // 最长上升子序列为 dp 数组的最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 最长递增子序列的长度：采用二分查找时间复杂度 O(NlogN)
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] dp = new int[N]; // dp[i] 代表长度为 i + 1 的上升子序列的最小尾数
        int len = 0; // 表示 dp 的当前长度，dp 的最终长度即为输出结果
        for(int num : nums) {
            // 因为 dp 显然是递增的，可以使用二分查找
            // 在 0 - len 范围内找到大于 num 的最小数，将它替换为 num
            // 如果所有数都小于 num 那意味着 num 作为末尾可以增加 dp 的长度
            int left = 0;
            int right = len;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(dp[mid] < num) left = mid + 1;
                else right = mid;
            }
            // left == right
            dp[left] = num;
            if(len == right) len++; // num 可以增加 dp 的长度
        }
        return len;
    }

    /**
     * 最长递增子序列的个数
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxLen = 1;
        int N = nums.length;
        int[] dp = new int[N];    // dp[i] 代表以 nums[i] 结尾的最长上升子序列的长度
        int[] count = new int[N]; // count[i] 代表以 nums[i] 结尾的最长上升子序列的个数
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                // 如果nums[i] > nums[j] 表示 nums[i] 可以加入
                if(nums[i] > nums[j]) {
                    if(dp[i] <= dp[j]) { // 需要更新dp[i]
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }else if(1 + dp[j] == dp[i]){ // 说明找到了长度相同的不同子序列
                        count[i] += count[j];
                    }
                }
            }
            // 更新最长上升子序列的长度
            maxLen = Math.max(maxLen, dp[i]);
        }
        // 统计最长上升子序列的数目，找到dp[i] == maxLen，然后累加对应的count[i]
        int res = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] == maxLen) res += count[i];
        }
        return res;
    }
}
