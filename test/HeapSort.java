import com.learn.algorithm.sort.SortUtils;

/**
 * @author yymuhua
 * @create 2020-04-17 22:27
 */
public class HeapSort {
    public static int[] heapSort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        buildHeap(nums);
        while(N > 0) {
            adjustHeap(nums, 0, N);
            SortUtils.swap(nums, 0, N - 1);
            N--;
        }
        return nums;
    }
    private static void buildHeap(int[] nums) {
        int N = nums.length;
        for(int i = N / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, N);
        }
    }
    private static void adjustHeap(int[] nums, int start, int end) {
        int minimum = start;
        int left = 2 * start + 1;
        int right = 2 * start + 2;
        if(left < end && nums[left] < nums[minimum]) {
            minimum = left;
        }
        if(right < end && nums[right] < nums[minimum]) {
            minimum = right;
        }
        if(minimum != start) {
            SortUtils.swap(nums, start, minimum);
            adjustHeap(nums, minimum, end);
        }
    }
}
