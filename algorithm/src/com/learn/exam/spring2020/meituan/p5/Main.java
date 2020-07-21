package com.learn.exam.spring2020.meituan.p5; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */
//第一行2个数n,m，代表序列长度和询问次数
//
//        第二行n个数字，中间没有空格。每个数字为0或者1，第 i 个数代表序列中第i个数的大小
//
//        接下来m行，每行一个询问。其中，两个操作的询问方式如下：
//
//        1.c x y将区间[x,y]的0变为1,1变为0。
//
//        2.q 询问整段序列的最长不下降子序列长度。
//
//        注意，序列的第一个位置从开始标号，意思为整个序列的下标为1,2...n
//
//        1≤n≤100000 , 1≤m≤100000 , 1≤x≤y≤n

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define input value
        while (sc.hasNextInt()) {
            // get test value
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[] arr = sc.nextLine().toCharArray();
            String[] opers = new String[m];
            int cntQ = 0;
            for (int i = 0; i < m; i++) {
                opers[i] = sc.nextLine();
                if (opers[i].equals("q")) cntQ++;
            }
            int[] res = new int[cntQ];
            // to do

            // output
            for (int i = 0; i < res.length; i++) {
                res[i] = 2;
                System.out.println(res[i]);
            }
        }
        sc.close();
    }
}
