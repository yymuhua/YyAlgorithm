package com.learn.algorithm.backtrack;//package com.learn.algorithm.backtrack;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * N皇后问题：返回所有可能的摆放位置
// * @author yymuhua
// * @create 2020-04-07 19:23
// */
//public class EightQueen {
//    public static void main(String[] args) {
//        EightQueen e = new EightQueen();
//        System.out.println(e.solveNQueens(4));
//    }
//    // private boolean[] row; // row[i] = true 代表第 i 行不允许放置
//    private boolean[] col; // col[i] = true 代表第 i 行不允许放置
//    private boolean[] diag1; // 主对角线 index = x + y
//    private boolean[] diag2; // 副对角线 index = n - 1 + x - y;
//    private int n;
//    private String base;
//    public List<List<String>> solveNQueens(int n) {
//        col = new boolean[n];
//        diag1 = new boolean[2 * n - 1];
//        diag2 = new boolean[2 * n - 1];
//        base = ".".repeat(n);
//        this.n = n;
//        return helper(0);
//    }
//    private List<List<String>> helper(int x) {
//        List<List<String>> res = new ArrayList<>();
//        if(x >= n) return res;
//        for(int y = 0; y < n; y++) {
//            if(placeable(x, y)) {
//                // 1. 选择
//                place(x, y);
//                StringBuilder sb = new StringBuilder(base);
//                sb.setCharAt(y, 'Q');
//                String line = sb.toString();
//                // 2. 往下一层走
//                List<List<String>> lists = helper(x + 1);
//                if(x == n - 1) {
//                    List<String> list = new ArrayList<>();
//                    list.add(line);
//                    res.add(list);
//                }else {
//                    for(List<String> list : lists) {
//                        list.add(0, line);
//                        res.add(list);
//                    }
//                }
//                // 3. 撤销选择
//                cancel(x, y);
//            }
//        }
//        return res;
//    }
//    // 放置操作
//    private void place(int x, int y) {
//        col[y] = true;
//        diag1[x + y] = true;
//        diag2[n - 1 + x - y] = true;
//    }
//    // 取消操作
//    private void cancel(int x, int y) {
//        col[y] = false;
//        diag1[x + y] = false;
//        diag2[n - 1 + x - y] = false;
//    }
//    // 判断位置是否可放置
//    private boolean placeable(int x, int y) {
//        return !col[y] && !diag1[x + y] && !diag2[n - 1 + x - y];
//    }
//}
