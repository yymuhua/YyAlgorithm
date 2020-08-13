/**
 * @author yymuhua
 * @create 2020-04-21 10:11
 */
public class Trade {
    // 股票交易，限制1次
    public static int trade1(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return 0;

        int[] dp = new int[2]; // dp[0] 代表当天未持有股票，dp[1] 代表持有
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            dp[0] = Math.max(dp[0], dp[1] + nums[i - 1]); // 前一天就未持有或者前一天持有了，今天卖出
            dp[1] = Math.max(dp[1], - nums[i - 1]); // 前一天就持有今天保持或者今天买进，因为只有一次机会，不用累加收益
        }
        return dp[0];
    }
    // 股票交易2，无限次数
    public static int trade2(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return 0;

        int[] dp = new int[2]; // dp[0] 代表当天未持有股票，dp[1] 代表持有
        // base case
        dp[0] = 0;
        dp[1] = -Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            int lastDp0 = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + nums[i - 1]); // 前一天就未持有或者前一天持有了，今天卖出
            dp[1] = Math.max(dp[1], lastDp0 - nums[i - 1]); // 前一天就持有今天保持或者今天买进，因为只有一次机会，不用累加收益
        }
        return dp[0];
    }
    // 股票交易，K次机会
    public static int trade3(int[] nums, int K) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return 0;
        int[][] dp = new int[K + 1][2]; // dp[i][j] 代表当前交易次数为i，持有股票状态为j
        // base case
        for(int i = 0; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = -Integer.MIN_VALUE;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = K; j >= 1; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + nums[i - 1]);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - nums[i - 1]);
            }
        }
        return dp[K][0]; // 交易了K次且未持有股票收益最大
    }
    public static int binary(int[] arr, int a) {
        int N;
        if(arr == null || (N = arr.length) == 0) return -1;
        int left = 0;
        int right = N - 1;
        while(left < right) {
            // 访问mid和mid+1
            int mid = left + (right - left) / 2;
            if(arr[mid] < a && arr[mid + 1] >= a) return arr[mid];
            else if(arr[mid + 1] <= a) left = mid + 1;
            else right = mid; // arr[mid] <= a
        }
        // left == right
        if(arr[left] >= a) return -1;
        return arr[left];
    }
}

