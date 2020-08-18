package com.learn.exam.autumn2020.tencent.day0817.t1;

/**
 * @author yymuhua
 * @create 2020-08-17 15:57
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Deque<String> stack = new ArrayDeque<>();
        Deque<Integer> stackNum = new ArrayDeque<>();
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == '[') {
                stack.push("[");
                int numStart = index + 1;
                int numEnd = numStart;
                while (numEnd < s.length() && s.charAt(numEnd) > '0' && s.charAt(numEnd) < '9') {
                    numEnd++;
                }
                stackNum.push(Integer.parseInt(s.substring(numStart, numEnd)));
                index = numEnd;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                repeat(sb, stackNum.pop());
                stack.pop();
                stack.push(sb.toString());
            } else {
                stack.push(s.substring(index, index + 1));
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        System.out.println(sb.toString());
        sc.close();
    }

    private static void repeat(StringBuilder sb, int cnt) {
        String base = sb.toString();
        for (int i = 1; i < cnt; i++) {
            sb.append(base);
        }
    }
}
