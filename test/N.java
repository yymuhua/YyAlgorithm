import com.learn.algorithm.sort.SortUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yymuhua
 * @create 2020-04-20 22:22
 */
public class N {
    /**
     * 下一个更大的排列
     * @param nums
     * @return
     */
    public static int[] method(int[] nums) {
        int N;
        if(nums == null || (N = nums.length) == 1) return nums;
        int bound = N - 1; // 分界点，前面的部分保持不变，bound - 1位置变为更大的数字
        while(bound > 0) {
            if(nums[bound - 1] < nums[bound]) {
                // 此时的bound - 1位置需要变为下一个更大的数
                // 从[bound, N) 找到大于 nums[bound - 1] 的最小的数
                int temp = bound;
                while(temp < N && nums[temp] < nums[bound - 1]) {
                    temp++;
                }
                SortUtils.swap(nums, bound - 1, temp - 1);
                break;
            }
            bound--;
        }
        // 此时[bound, N) 为降序，需要变为升序才刚好是下一个更大的排列
        int left = bound;
        int right = N - 1;
        while(left < right) {
            SortUtils.swap(nums, left, right);
        }
        return nums;
    }

    /**
     * 表达式转换为逆波兰表达式
     * @param s
     * @return
     */
    public static String methods(String s) {
        int N;
        if(s == null || (N = s.length()) == 0) return s;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        // 按照优先级如操作符栈，入栈时需要将栈内全部优先级更高的操作符输出
        // 遇到反括号，操作符栈一直输出直到遇到正括号
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') sb.append(c);
            else if(c == '(') stack.push(c);
            else if(c == ')') {
                while(!stack.isEmpty() && !stack.peek().equals('(')) {
                    sb.append(stack.pop());
                }
                stack.pop();
            }else {
                int level = getLevel(c);
                char topChar;
                while(!stack.isEmpty() && (topChar = stack.peek()) != '(' && getLevel(topChar) >= level) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    private static int getLevel(char c) {
        switch(c) {
            case '(': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(methods("3*5"));
        System.out.println(methods("3*5+(1+2)*1"));
    }
}
