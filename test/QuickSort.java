/**
 * @author yymuhua
 * @create 2020-04-17 22:13
 */
public class QuickSort {
    public static int[] quickSort(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) <= 1) return nums;
        helper(nums, 0, N);
        return nums;
    }
    private static void helper(int[] nums, int start, int end) {
        if(start >= end - 1) return ;
        int left = start;
        int right = end - 1;
        int keyIndex = left;
        int keyNum = nums[right];
        while(left < right) {
            // 空位为 left ，需要从右到左找一个合适的填入
            while(left < right && keyNum < nums[right]) {
                right--;
            }
            if(left < right) {
                nums[left] = nums[right];
                left++;
            }
            // 空位为 right, 从左到右找一个合适的填入
            while(left < right && nums[left] <= keyNum) {
                left++;
            }
            if(left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        // left == right
        keyIndex = left;
        nums[keyIndex] = keyNum;
        helper(nums, start, keyIndex);
        helper(nums, keyIndex + 1, end);
    }
}
