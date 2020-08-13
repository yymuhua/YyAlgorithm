import com.learn.algorithm.sort.SortUtils;

/**
 * @author yymuhua
 * @create 2020-04-17 22:35
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        for(int i = N - 1; i > 0; i--) {
            // 每次都将[0, i]最大的值冒泡至索引 i 位置
            boolean sorted = true;
            for(int j = 0; j <= i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    sorted  = false;
                    SortUtils.swap(nums, j, j + 1);
                }
                if(sorted) break;
            }
        }
        return nums;
    }
}
