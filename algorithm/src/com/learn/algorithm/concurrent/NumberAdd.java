package com.learn.algorithm.concurrent;


import java.util.concurrent.CountDownLatch;

/**
 * @author yymuhua
 * @create 2020-03-25 14:24
 */
public class NumberAdd {
    //    public static AtomicInteger num = new AtomicInteger(0);
    public static int num1 = 0;
    public static final Object lock = new Object();
    public static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("init value of num1 = " + num1);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                synchronized (lock) {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(name + " -> num1 = " + (++num1));
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("final value of num1 = " + num1);
    }
}
