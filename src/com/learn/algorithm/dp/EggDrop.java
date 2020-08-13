package com.learn.algorithm.dp;

/**
 * 高楼扔鸡蛋问题：
 * 你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。
 * 现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎）。
 * 现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？
 * @author yymuhua
 * @create 2020-03-27 13:58
 */
public class EggDrop {
    public static void main(String[] args) {
        System.out.println(superEggDrop(22, 3234));
    }

    private static int[][] dp;
    private static int K;
    private static int N;

    /**
     *
     * @param k
     * @param n
     * @return
     */
    public static int superEggDrop(int k, int n) {
        // dp[i][j] i 个鸡蛋，j 层楼的问题规模
        // 加入从 i 层楼扔下一个鸡蛋，得到状态转移方程
        // dp[K][N] = 1 + Math.max(dp[K - 1][i - 1], dp[K][N - i])
        // 解释：如果鸡蛋碎了，表示目标F位于 0 -> i - 1 之间，缩小问题规模为 i - 1 个楼层
        //      如果鸡蛋没碎，表示目标F位于 i -> N 之间，缩小问题规模为 N - i 个楼层
        K = k;
        N = n;
        dp = new int[K + 1][N + 1];
        return dp(K, N);
    }
    private static int dp(int k, int n) {
        // 1. base case
        // 如果楼层规模为0，显然不需要扔了
        // 如果只有一个鸡蛋，那么最差情况有多少楼层，就要扔多少次
        if(n <= 0) return 0;
        if(k == 1) return n;
        // 1.1 dp数组作为备忘录，减少重复计算
        if(dp[k][n] != 0) return dp[k][n];
        int res = Integer.MAX_VALUE;
        // 2. 遍历填充数组，采用二分查找
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            // 鸡蛋从第 mid 层扔，两种情况
            // 如果蛋碎了，接下来需要的操作次数
            int broken = dp(k - 1, mid - 1);
            // 如果蛋没碎，接下来需要操作的次数
            int notBroken = dp(k, n - mid);
            // 因为是要求是最坏的情况，取上面两者中的较大者
            res = Math.min(res, 1 + Math.max(broken, notBroken));
            // broken 是 mid 的增函数
            // notBroken 是 mid 的减函数
            // 我们的目标是找出Math.max(broken, notBroken)，即两者的交点
            // 据此可以得到下一步的搜索范围
            if(broken > notBroken) right = mid - 1;
            else left = mid + 1;
        }
        dp[k][n] = res;
        return res;
    }
}
