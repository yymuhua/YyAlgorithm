package com.learn.algorithm.math.uglynum;

/**
 * 丑数问题：因数只有 2,3,5 的数被称为丑数
 * 1 2 3 4 5 6 8 ...
 *
 * @author yymuhua
 * @create 2020-03-29 18:51
 */
public class UglyNum {
    /**
     * 判断一个数是不是丑数
     */
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }

    /**
     * 找出第n个丑数
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;

        int[] nums = new int[n + 1]; // nums[i] 代表第 i 个丑数
        // 任何一个丑数都能通过比它小的另一个丑数通过 * 2 或 * 3 或 * 5 得到
        nums[1] = 1;
        int indexOf2 = 1;
        int indexOf3 = 1;
        int indexOf5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = nums[indexOf2] * 2;
            int num3 = nums[indexOf3] * 3;
            int num5 = nums[indexOf5] * 5;
            // 找出三个中的最小者
            nums[i] = Math.min(num2, Math.min(num3, num5));
            if (nums[i] == num2) indexOf2++;
            if (nums[i] == num3) indexOf3++;
            if (nums[i] == num5) indexOf5++;
        }
        return nums[n];
    }
}
