package com.learn.algorithm.concurrent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yymuhua
 * @create 2020-04-14 17:33
 */
public class MyBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;
    public MyBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("ddd");
    }

    public synchronized void add(int num) {
        while(queue.size() == capacity) {
            System.out.println("队列已满，等待消费者消费产品！");
            try {this.wait(); } catch (Exception e) {}
        }
        this.notify();
        queue.add(num);
    }
    public synchronized int remove() {
        while(queue.size() == 0) {
            System.out.println("队列为空，等待生产者添加产品！");
            try {this.wait(); } catch (Exception e) {}
        }
        int res = queue.remove();
        this.notify();
        return res;
    }

    public static void main(String[] args) {
        MyBlockingQueue mbq = new MyBlockingQueue(3);
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("准备生产产品，编号：" + finalI);
                mbq.add(finalI);
                System.out.println("产品生产完毕，编号：" + finalI);
            }).start();
            try {Thread.sleep(500);}catch (Exception e){}
        }
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("准备消费产品");
                int num = mbq.remove();
                System.out.println("消费，编号：" + num);
            }).start();
            try {Thread.sleep(800);}catch (Exception e){}
        }
    }
}
