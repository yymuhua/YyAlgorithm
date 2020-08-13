package com.learn.algorithm.linkedlist;

import com.learn.algorithm.ListNode;

/**
 * 反转链表相关。
 * 反转链表的过程：pre -> curr -> A -> B -> C
 *               pre -> A -> curr -> B -> C
 *               pre -> B -> A -> curr -> C
 * 核心思想（从curr开始反转）：初始有一个pre和curr，每次都将curr.next移到pre之后（紧挨着）
 * @author yymuhua
 * @create 2020-04-19 19:34
 */
public class Reverse {
    /**
     * LeetCode 206. 反转链表。反转整个链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // 遍历，每次都将head.next移到preHead之后
        while(head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = preHead.next;
            preHead.next = temp;
        }
        return preHead.next;
    }

    /**
     * LeetCode 25. K 个一组翻转链表。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        int N = 0;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        while(head != null) {
            head = head.next;
            N++;
        }
        head = preHead.next;
        ListNode pre = preHead;
        // 总共需要反转 N / k 次
        for(int i = 0; i < N / k; i++) {
            for(int j = 0; j < k - 1; j++) {
                // 每次都将 head.next 移到 pre 之后
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = head;
            head = head.next;
        }
        return preHead.next;
    }
}
