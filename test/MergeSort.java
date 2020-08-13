import java.util.Arrays;

/**
 * @author yymuhua
 * @create 2020-04-17 22:50
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        int mid = N / 2;
        int[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(nums, mid, N));
        return mergeTwo(left, right);
    }
    private static int[] mergeTwo(int[] left, int[] right) {
        int N1, N2;
        if(left == null || (N1 = left.length) == 0) return right;
        if(right == null || (N2 = right.length) == 0) return left;
        int p1 = 0;
        int p2 = 0;
        int[] res = new int[N1 + N2];
        while(p1 < N1 && p2 < N2) {
            if(left[p1] < right[p2]) {
                res[p1 + p2] = left[p1];
                p1++;
            }else {
                res[p1 + p2] = right[p2];
                p2++;
            }
        }
        // p1 == N1 || p2 == N2
        while(p1 < N1) {
            res[p1 + p2] = left[p1];
            p1++;
        }
        while(p2 < N2) {
            res[p1 + p2] = right[p2];
            p2++;
        }
        return res;
    }
}
