package com.learn.algorithm.design;

/**
 * @author yymuhua
 * @create 2020-04-08 22:40
 */
public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        for(int i = 0; i < 10000; i++) {
            map.put(i, i + 1);
        }
        for(int i = 0; i < 10000; i++) {
            System.out.println(map.get(i));
        }

    }
    Node[] table;
    int size;
    int threshod;
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[16];
        size = 0;
        threshod = 12;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key & (table.length - 1);
        Node curr;
        if((curr = table[index]) == null) {
            table[index] = new Node(key, value);
        }else {
            while(curr.next != null) {
                if(curr.key == key) {
                    curr.value = value;
                    return ;
                }
                curr = curr.next;
            }
            if(curr.key == key) {
                curr.value = value;
                return ;
            }
            curr.next = new Node(key, value);
            size++;
        }
        if(size > threshod) {
            resize();
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node node = getNodes(key)[1];
        return node == null ? -1 : node.value;
    }
    private Node[] getNodes(int key) {
        int index = key & (table.length - 1);
        Node curr;
        Node[] res = new Node[2];
        if((curr = table[index]) == null) {
            return res;
        }else {
            Node pre = null;
            while(curr != null) {
                if(curr.key == key) return new Node[] {pre, curr};
                pre = curr;
                curr = curr.next;
            }
        }
        return res;
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key & (table.length - 1);
        Node[] nodes = getNodes(key);
        if(nodes[1] == null) return ;
        if(nodes[0] == null) {
            table[index] = table[index].next;
            size--;
            return ;
        }
        nodes[0].next = nodes[1].next;
        nodes[1].next = null;
        size--;
    }
    private void resize() {
        int N;
        if((N = table.length) >= (Integer.MAX_VALUE >> 1)) return ;
        Node[] newT = new Node[N << 1];
        for(int i = 0; i < N; i++) {
            Node curr;
            if((curr = table[i]) != null) {
                Node[] tail = new Node[2];
                while(curr != null) {
                    int newIdx = curr.key & (newT.length - 1);
                    if(tail[newIdx / N] == null) {
                        newT[newIdx] = copy(curr);
                        tail[newIdx / N] = newT[newIdx];
                    }else {
                        tail[newIdx / N].next = copy(curr);
                        tail[newIdx / N] = tail[newIdx / N].next;
                    }
                    curr = curr.next;
                }
            }
        }
        table = newT;
        threshod = (threshod << 1);
    }
    private Node copy(Node n) {
        return new Node(n.key, n.value);
    }
    class Node {
        int key;
        int value;
        Node next;
        public Node(int k, int val) {
            key = k;
            value = val;
        }
    }
}
