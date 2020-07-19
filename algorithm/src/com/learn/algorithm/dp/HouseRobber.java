package com.learn.algorithm.dp;

import com.learn.algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍问题
 * 输入一个数组代表N个房屋以及房屋内的价值，如果偷了相邻两个房屋会触发报警。
 * 问：如何在不报警的前提下偷取最高的价值
 *
 * @author yymuhua
 * @create 2020-03-27 16:05
 */
public class HouseRobber {
    public static void main(String[] args) {

    }
//======================================================================

    /**
     * 打家劫舍1
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] 定义为偷前 i 间屋子，能获得的最大收益
        // 状态转移：
        //          偷 nums[i]：dp[i] = nums[i] + dp[i - 2];
        //          不偷 nums[i]：dp[i] = dp[i - 1];
        // base case：dp[0] = nums[0]
        // for(int i = 0; i < n; i++) {
        //     int stealI = i - 2 >= 0 ? nums[i] + dp[i - 2] : nums[i];
        //     int notStealI = i - 1 >= 0 ? dp[i - 1] : 0;
        //     dp[i] = Math.max(stealI, notStealI);
        // }
        // 空间优化：dp[i] 只与dp[i - 2] 和dp[i - 1]相关，只需要两个变量即可
        int dpi2 = 0;
        int dpi1 = 0;
        for (int i = 0; i < n; i++) {
            int stealI = nums[i] + dpi2;
            int notStealI = dpi1;
            dpi2 = dpi1;
            dpi1 = Math.max(stealI, notStealI);
        }
        return dpi1;
    }
//======================================================================

    /**
     * 打家劫舍2：所有房屋连成环（nums[n - 1]与nums[0]相邻）
     * 思路：分解为三个打家劫舍1问题
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // 如果偷nums[n - 1]，nums[0] 和 nums[n - 2] 都不能偷 <- rob2Helper(1, n - 3)
        // 如果偷nums[0]，nums[1] 和 nums[n - 1] 都不能偷 <- rob2Helper(2, n - 2)
        // 如果都不偷 <- rob2Helper(1, n - 2)
        int stealTail = nums[n - 1] + rob2Helper(nums, 1, n - 3);
        int stealHead = nums[0] + rob2Helper(nums, 2, n - 2);
        int notSteal = rob2Helper(nums, 1, n - 2);
        return Math.max(stealHead, Math.max(stealTail, notSteal));
    }

    /**
     * 从数组的start偷到end能获取的最大价值 <- [start, end]闭区间
     */
    private static int rob2Helper(int[] nums, int start, int end) {
        if (start > end) return 0;
        int dpi2 = 0;
        int dpi1 = 0;
        for (int i = start; i <= end; i++) {
            int stealI = nums[i] + dpi2;
            int notStealI = dpi1;
            dpi2 = dpi1;
            dpi1 = Math.max(stealI, notStealI);
        }
        return dpi1;
    }
//======================================================================

    private Map<TreeNode, Integer> memo = new HashMap<>();

    /**
     * 房子是二叉树，相邻的房子不能偷，求最大偷取的价值
     *
     * @param root
     * @return
     */
    public int rob3(TreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢根，这样 root.left 和 root.right 都不能抢了
        int stealRoot = root.val
                + (root.left == null ?
                0 : rob3(root.left.left) + rob3(root.left.right))
                + (root.right == null ?
                0 : rob3(root.right.left) + rob3(root.right.right));
        // 不抢根，root.left 和 root.right 均可以抢
        int notStealRoot = rob3(root.left) + rob3(root.right);

        int res = Math.max(stealRoot, notStealRoot);
        memo.put(root, res);
        return res;
    }
}
