import java.util.Arrays;

/**
 * @author yymuhua
 * @create 2020-04-21 10:01
 */
public class Package {
//    有N块石头，重量分别为W[i]，一个背包（重量）容量为C，求背包的最重重量
    public static int method(int[] W, int C) {
        int N;
        if(W == null || (N = W.length) == 0) return 0;
        int[][] dp = new int[N + 1][C + 1]; // dp[i][j]代表从前i块石头中装容量为j的背包，能装的最重重量
        // base case
//        Arrays.fill(dp[0], 0);
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= C; j++) {
                // 能否装下W[i - 1]
                dp[i][j] = dp[i - 1][j];
                if(j >= W[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - W[i - 1]] + W[i - 1]);
                }
            }
        }
        return dp[N][C];
    }
    public static int method2(int[] W, int C) {
        int N;
        if(W == null || (N = W.length) == 0) return 0;
        int[] dp = new int[C + 1]; // dp[j]代表从当前石头堆中装容量为j的背包，能装的最重重量
        // base case
//        Arrays.fill(dp[0], 0);
        for(int i = 1; i <= N; i++) {
            // 每次考虑的石头堆为[0, i)
            for(int j = C; j >= W[i - 1]; j--) {
                dp[j] = Math.max(dp[j], W[i - 1] + dp[j - W[i - 1]]);
            }
        }
        return dp[C];
    }

}
