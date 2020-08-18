package com.learn.exam.autumn2020.tencent.day0817.t2;

/**
 * 单调栈：小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 他想知道他在每栋楼的位置处能看到多少栋楼呢？（包括自己所在的楼）
 * @author yymuhua
 * @create 2020-08-17 15:57
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        // stack中要保存的是能看见的楼的 index
        int[] count = new int[n];
        Stack<Integer> view = new Stack<>();
        // 往右看
        for (int i = n - 1; i >= 0; i--) {
            count[i] = view.size();
            // 将视野里被nums[i]挡住的全部删掉
            while((!view.isEmpty()) && (nums[i] >= nums[view.peek()])){
                view.pop();
            }
            view.push(i);
        }
        view.clear();
        // 往左看
        for (int i = 0 ; i < n ; i++) {
            int total = count[i] + view.size();
            while((!view.isEmpty()) && (nums[i] >= nums[view.peek()])){
                view.pop();
            }
            System.out.print(total + 1 + " ");
            view.push(i);
        }
    }
}
