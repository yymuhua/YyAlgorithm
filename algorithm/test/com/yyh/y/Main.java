package com.yyh.y;

/**
 * @author yeyuhua
 * @version 1.0
 * @created 2020/7/29 5:11 下午
 */
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner input;
        int N, K;

        input = new Scanner(System.in);
        while(input.hasNext()){
            N = input.nextInt();
            K = input.nextInt();
            System.out.println(new Main().Solution(N, K));
        }
    }

    private long Solution(int N, int K){
        int M;
        long[][] A, An;

        M = 1000000007;
        if(N == 1)
            return 0;
        if(N == 2)
            return K - 1;
        A = new long[][]{{K - 2, 1}, {K - 1, 0}};
        An = pow(A, N - 2);
        return An[0][0] * (K - 1) % M;
    }

    private long[][] pow(long[][] A, int n){
        Stack<Integer> stack;
        long[][] ans;

        stack = new Stack<>();
        ans = new long[][]{{1, 0}, {0, 1}};
        while(n > 0){
            stack.push(n % 2);
            n /= 2;
        }
        while(!stack.isEmpty()){
            multi(ans, ans);
            if(stack.pop() == 1)
                multi(ans, A);
        }
        return ans;
    }

    private void multi(long[][] A, long[][] B){
        long a00, a01, a10, a11;
        int M;

        M = 1000000007;
        a00 = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % M;
        a01 = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % M;
        a10 = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % M;
        a11 = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % M;
        A[0][0] = a00;
        A[0][1] = a01;
        A[1][0] = a10;
        A[1][1] = a11;
    }
}
