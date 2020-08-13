package com.learn.exam.autumn2020.yuandudao.t2; /**
 * @author yymuhua
 * @create 2020-03-16 21:50
 */

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static final BigInteger BASE = BigInteger.valueOf(1000000003);
    public static BigInteger ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Node> map = new HashMap<>();
        Node preRoot = new Node(0);
        preRoot.subs = new ArrayList<>();
        map.put(0, preRoot);
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Node curr;
            if (map.containsKey(i + 2)) {
                curr = map.get(i + 2);
                curr.val = a;
            } else {
                curr = new Node(a);
            }
            curr.subs = new ArrayList<>();
            map.put(i + 2, curr);
            if (!map.containsKey(b)) {
                Node father = new Node(0);
                father.subs = new ArrayList<>();
                map.put(b, father);
            }
            List<Node> subs = map.get(b).subs;
            subs.add(curr);
        }
        Node root = preRoot.subs.get(0);
        ans = BigInteger.valueOf(root.val);
        maxVal(root);
        System.out.println(ans.mod(BASE));
        sc.close();
    }
    public static BigInteger maxVal(Node root) {
        if (root == null) {
            return BigInteger.ZERO;
        }
        BigInteger res = BigInteger.valueOf(root.val);
        if (root.subs == null || root.subs.size() == 0) {
            ans = compare(ans, res);
            return res;
        }
        BigInteger sum = BigInteger.ZERO;
        for (Node sub : root.subs) {
            BigInteger subMax = maxVal(sub);
            if (subMax.compareTo(BigInteger.ZERO) == 1) {
                sum = sum.add(subMax);
            }
        }
        res = res.add(sum);
        ans = compare(res, ans);
        return res;
    }
    static class Node {
        int val;
        List<Node> subs;
        public Node(int val) {
            this.val = val;
        }
    }
    public static BigInteger compare(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == 1) {
            return a;
        } else {
            return b;
        }
    }
}
