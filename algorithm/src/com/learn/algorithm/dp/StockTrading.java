package com.learn.algorithm.dp;

/**
 * 股票买卖问题：prices为市价
 * i 代表时间，k代表已经完成的交易次数（一次完整的买卖），0/1代表未持有/持有股票，dp的值代表获利
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
 * max(   选择 rest  ,           选择 sell      )
 * 解释：今天我没有持有股票，有两种可能：
 * 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
 * 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
 * <p>
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
 * max(   选择 rest  ,           选择 buy         )
 * 解释：今天我持有着股票，有两种可能：
 * 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
 * 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
 *
 * @author yymuhua
 * @create 2020-03-27 17:08
 */
public class StockTrading {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit3(nums));
    }
//===================================================================

    /**
     * 股票买卖问题1：只允许买卖一次，求最大获利
     * k只能为 1，因此可以去掉这个维度
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        /*
        int[][] dp = new int[n + 1][2]; // 显然dp[n][0]就是输出目标
        // base case：第0天如果持有股票，
        dp[0][0] = 0;
        dp[0][1] = -Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i - 1]); // 此处为 - prices[i - 1]就确保了只有一次交易的收益
        }
        return dp[n][0];
        */
        // 考虑到dp[i]只与dp[i - 1]相关，可以去掉这个维度
        int[] dp = new int[2]; //
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], -prices[i - 1]);
        }
        return dp[0];
    }
//===================================================================

    /**
     * 股票买卖2：允许无限次交易
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        // 考虑到dp[i]只与dp[i - 1]相关，可以去掉这个维度
        int[] dp = new int[2]; //
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int lastDP0 = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], lastDP0 - prices[i - 1]);
        }
        return dp[0];
    }

//===================================================================

    /**
     * 买卖股票3：如果限制交易次数为2，求最大获利
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        int tradeCnt = 2; // 允许交易的次数
        int[][] dp = new int[tradeCnt + 1][2]; // 依然可以省去天数那个维度
        // base case
        for (int k = 1; k <= tradeCnt; k++) {
            dp[k][0] = 0;
            dp[k][1] = -Integer.MIN_VALUE;
        }
        // 遍历枚举全部清空
        for (int i = 1; i <= n; i++) {
            for (int k = tradeCnt; k >= 1; k--) { // 遍历的反向必须要确保dp[k - 1]是昨天的 k - 1，也即k - 1要在k之后更新
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i - 1]);
                if (k == 1) {
                    dp[k][1] = Math.max(dp[k][1], -prices[i - 1]); // 代表第一次买入，启动资金为 0
                } else {
                    dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[i - 1]);
                }
            }
        }
        return dp[tradeCnt][0]; // 最后肯定是交易次数为tradeCnt且未持有股票时获利最大
    }
//===================================================================

    /**
     * 股票买卖4：如果限制交易次数为 K ，求最大获利
     * 关键在于K如果过大，内存会溢出
     *
     * @param prices
     * @return
     */
    public static int maxProfit4(int K, int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        if (K > n / 2) { // 如果允许交易次数超过长度的一般，等价于允许无限次交易
            return maxProfit2(prices);
        }
        int[][] dp = new int[K + 1][2]; // 依然可以省去天数那个维度
        // base case
        for (int k = 1; k <= K; k++) {
            dp[k][0] = 0;
            dp[k][1] = -Integer.MIN_VALUE;
        }
        // 遍历枚举全部清空
        for (int i = 1; i <= n; i++) {
            for (int k = K; k >= 1; k--) { // 遍历的反向必须要确保dp[k - 1]是昨天的 k - 1，也即k - 1要在k之后更新
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i - 1]);
                if (k == 1) {
                    dp[k][1] = Math.max(dp[k][1], -prices[i - 1]); // 代表第一次买入，启动资金为 0
                } else {
                    dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[i - 1]);
                }
            }
        }
        return dp[K][0]; // 最后肯定是交易次数为 K 且未持有股票时获利最大
    }
//===================================================================

    /**
     * 股票买卖5：含冷冻期，卖出的第二天不允许买入，不限制交易次数。
     *
     * @param K
     * @param prices
     * @return
     */
    public static int maxProfit5(int K, int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;

        int[] dp = new int[2]; //
        int lastlastDP0 = 0; // 代表前天的未持有股票状态收益
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int lastDP0 = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], lastlastDP0 - prices[i - 1]); // 不允许昨天卖的今天就买，只能前天卖的今天买
            lastlastDP0 = lastDP0;
        }
        return dp[0];
    }
//===================================================================

    /**
     * 股票买卖6：不限制交易次数，但是交易有手续费
     * 等价于买入价变贵了 fee！
     *
     * @param fee
     * @param prices
     * @return
     */
    public static int maxProfit6(int[] prices, int fee) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        // 考虑到dp[i]只与dp[i - 1]相关，可以去掉这个维度
        int[] dp = new int[2]; //
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int lastDP0 = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i - 1]);
            dp[1] = Math.max(dp[1], lastDP0 - fee - prices[i - 1]);
        }
        return dp[0];
    }
}
