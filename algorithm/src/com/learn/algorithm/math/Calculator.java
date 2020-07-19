package com.learn.algorithm.math;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 实现计算器
 *
 * @author yymuhua
 * @create 2020-04-16 20:44
 */
public class Calculator {
    /**
     * 实现简单计算器
     * 处理包含四则运算符和括号的表达式（不考虑表达式不合法的情况）
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        int N;
        if (s == null || (N = s.length()) == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0; // 当前数值
        char sign = '+'; // 当前数值的符号
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);

            if (c == ' ') { // 1. 处理空格：直接跳过
                continue;
            }
            if (c == '(') { // 2. 处理括号：递归解决
                // 找到当前括号完整的表达式
                int start = i + 1;
                int cntP = 1;
                int cntN = 0;
                while (cntP != cntN) {
                    i++;
                    c = s.charAt(i);
                    if (c == '(') cntP++;
                    if (c == ')') cntN++;
                }
                num = calculate(s.substring(start, i));
                i++;
                continue;
            }
            if (isDigit(c)) { // 3. 处理数字：更新 num
                num = 10 * num + (c - '0');
            }
            if (!isDigit(c) || i == N - 1) { // 4. 处理四则运算：遇到加减直接入栈，遇到乘除优先计算再入栈
                switch (sign) {
                    case '+': {
                        stack.push(num);
                        break;
                    }
                    case '-': {
                        stack.push(-num);
                        break;
                    }
                    case '*': {
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    }
                    case '/': {
                        int pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    }
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    //逆波兰表达式的生成
    //这里不考虑操作数大于等于两位，没有对除数进行非0判断，也没有考虑到负数以及小数。
    //这里规定运算符的优先级从大到小为：()、*、/、-。暂时只考虑四则运算。
    /*
     * 规则如下：
     * 1.读到的是操作数，直接输出；
     * 2.读到的是操作符（四则运算），记为read，将其与栈顶中的操作符（即为top）进行优先级比较，read>top,
     * 	  则read直接进栈，继续读取下一个字符；如果read<=top,top出栈，并输出到list集合中，read继续和
     * 	  栈顶元素比较；如果top为空，则read直接进栈；如果top为"(",那么read直接入栈，因为"("优先级最高；
     * 3.括号的处理：读到左括号"(",直接将其进栈，只有当遇到")"，"("才会弹出；读到")"时，将栈中从上往下最
     * 	  早出现的第一个"("上的元素全部一次弹出，并输出到list集合中，并弹出"(",但不输出到list集合中。
     * */

    public static String changeNotation(String s) {
        int N;
        if (s == null || (N = s.length()) <= 1) return s;
        //list集合用来存放逆波兰表达式的输出结果
        List<Character> list = new ArrayList<>();
        //定义一个栈，用来处理操作符
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == ' ') continue; // 跳过空格
            if (c >= '0' && c <= '9') { // 1. 如果是数字，则直接输出到list中
                list.add(c);
            } else if (c == '(') { // 2. 如果是'('的话直接压栈
                stack.push(c);
            } else if (c == ')') { // 3. 如果是')'的话，则弹出栈中第一个'('上的元素
                while (!stack.peek().equals('(')) {
                    list.add(stack.pop());
                }
                //弹出'('
                stack.pop();
            } else { // 4. c为四则运算符
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    // 获取当前操作符的权重
                    int p1 = getPriority(c);
                    // 获取栈顶操作符的权重
                    int p2 = getPriority(stack.peek());
                    // 当前操作符权重更大，直接入栈
                    if (p1 > p2) {
                        stack.push(c);
                    } else { // 则一直弹出栈顶元素，并输出到list集合中,直到将操作符压栈为止
                        while (!stack.isEmpty() && p1 <= p2) {
                            p2 = getPriority(stack.peek());
                            list.add(stack.pop());
                        }
                        //将read压栈
                        stack.push(c);
                    }
                }
            }
        }
        // 表达式循环判断结束后，弹出栈中的所有元素，并输出到list集合中
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        // 将list集合中的数据转为逆波兰表达式
        StringBuilder sb = new StringBuilder();
        for (Character str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static int getPriority(char c) {
        switch (c) {
            case '(': {
                return 0;
            }
            case '+':
            case '-': {
                return 1;
            }
            case '*':
            case '/': {
                return 2;
            }
            default: {
                return 3;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(calculate("3 * (-1 + 2)"));
        System.out.println(changeNotation("3*5+(1+2)*1"));
    }
}
