package com.learn.algorithm.dp;

/**
 * 2出现的次数
 *
 * @author yymuhua
 * @create 2020-03-31 11:58
 */
public class Num0f2s {
    public static void main(String[] args) {
        numberOf2sInRange(1000000000);
    }

    public static int numberOf2sInRange(int n) {
        if (n <= 1) return 0;
        // 统计 n 的位数
        int bit = 0;
        int temp = n;
        while (temp != 0) {
            bit++;
            temp /= 10;
        }
        long[] dp = new long[bit + 1]; // dp[i] 表示数值 n 的 i 个后缀表示的数的问题规模
        dp[1] = n % 10 >= 2 ? 1 : 0;
        // 例：n = 4867 => dp[1] = numberOf2sInRange(7), dp[2] = numberOf2sInRange(67) 类推
        // 从 dp[2] -> dp[3] 需要按 x67 的最高位数x分情况考虑
        // 如果是 067 ：dp[2] = (00->67) = dp[1]
        // 如果是 167 ：dp[2] = (0->99) + (00->67) = 100 * 2 / 10 + dp[1]
        // 如果是 267 ：dp[2] = (0->199) + (00->67) + (200->267) = 2 * (100 * 2 / 10) + dp[1] + 67 + 1
        // 如果是 367 ：dp[2] = (0->199) + (00->67) + (200->299) = 3 * (100 * 2 / 10) + dp[1] + 100
        for (int i = 2; i <= bit; i++) {
            long tens = (long) Math.pow(10, i);
            long num = n % tens;
            long hightestNum = num / (tens / 10);  // 最高位数
            long suffixNum = num % (tens / 10);    // 除最高位数外的后缀
            if (hightestNum <= 1) {
                dp[i] = hightestNum * (i - 1) * (tens / 100) + dp[i - 1];
            } else if (hightestNum == 2) {
                dp[i] = hightestNum * (i - 1) * (tens / 100) + dp[i - 1] + suffixNum + 1;
            } else {
                dp[i] = hightestNum * (i - 1) * (tens / 100) + dp[i - 1] + tens / 10;
            }
        }
        return (int) dp[bit];
    }
}
