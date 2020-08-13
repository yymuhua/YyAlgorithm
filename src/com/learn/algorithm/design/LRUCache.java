package com.learn.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 的全称是 Least Recently Used， 也就是说我们认为最近使⽤过的数据应该是是「有⽤的」
 * 很久都没⽤过的数据应该是⽆⽤的， 内存满了就优先删那些很久没⽤过的数据。
 * @author yymuhua
 * @create 2020-04-05 14:17
 */
public class LRUCache {
    private Map<Integer, Node> map;
    private DoubleList cache;
    private int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // 采用put方法更新
        int value = map.get(key).val;
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        // 1 如果本来已经包含key，先删除对应Node再更新一个Node到头部
        // 此时不存在容量满了的问题
        if(map.containsKey(key)) {
            Node thisNode = map.get(key);
            if(!cache.isFirst(thisNode)) {
                // 1.1 将原本key对应的Node删除
                cache.remove(thisNode);
                // 1.2 将Node添加到队列头
                cache.addFirst(thisNode);
            }
            thisNode.val = value;
            return ;
        }
        // 2 如果容量已经满了，需要先删除队尾元素
        if(cache.size() == capacity) {
            Node lastNode = cache.removeLast();
            if(lastNode != null) {
                map.remove(lastNode.key);
            }
        }
        Node newNode = new Node(key, value);
        cache.addFirst(newNode);
        map.put(key, newNode);
    }

    class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleList {
        private int size;
        private Node first;
        private Node last;
        public DoubleList() {
            size = 0;
            first = null;
            last = null;
        }
        public int size() {
            return size;
        }
        public boolean isFirst(Node node) {
            return node == first;
        }
        public void addFirst(Node node) {
            if(size == 0) {
                // 链表没有元素
                first = node;
                last = node;
            }else {
                // 有元素
                first.pre = node;
                node.next = first;
                first = node;
            }
            size++;
        }
        public Node removeLast() {
            if(size == 0) return null;
            Node removedLast = last;
            remove(last);
            return removedLast;
        }
        public void remove(Node node) {
            if(node == null || size == 0) return ;
            Node preNode = node.pre;
            Node nextNode = node.next;
            if(preNode != null) preNode.next = nextNode;
            if(nextNode != null) nextNode.pre = preNode;
            if(node == first) first = nextNode;
            if(node == last) last = preNode;
            node.pre = null;
            node.next = null;
            size--;
        }
    }
}
