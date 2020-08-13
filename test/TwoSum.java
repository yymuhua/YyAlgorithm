import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-18 10:36
 */
public class TwoSum {
    public static void main(String[] args) {
        List<int[]> ints = twoSum(new int[]{0, 1, 1, 1, 2, 3, 4}, 3);
        for(int[] pair : ints) {
            System.out.println(Arrays.toString(pair));
        }
    }
    public static List<int[]> twoSum(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        int N;
        if(nums == null || (N = nums.length) <= 1) return res;
        Arrays.sort(nums);
        int left = 0;
        int right = N - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                res.add(new int[]{nums[left], nums[right]});
            }
            if(sum >= target) {
                // 更新 right
                int temp = right - 1;
                while(temp > left && nums[temp] == nums[right]) {
                    temp--;
                }
                right = temp;
            }
            if(sum <= target){
                // 更新 left
                int temp = left + 1;
                while(temp < right && nums[temp] == nums[left]) {
                    temp++;
                }
                left = temp;
            }
        }
        return res;
    }
}
