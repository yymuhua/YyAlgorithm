package com.learn.algorithm.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author yymuhua
 * @create 2020-04-14 11:19
 */
public class CountDownLatchTest {
    public static CountDownLatch countDownLatch;

    public static void main(String[] args) {
        countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("[" + name + "]" + "阶段1完成");
            System.out.println("[" + name + "]" + "阶段2完成");
            countDownLatch.countDown();
            System.out.println("[" + name + "]" + "阶段3完成");
        }).start();
        new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("[" + name + "]" + "阶段1完成");
            countDownLatch.countDown();
            System.out.println("[" + name + "]" + "阶段2完成");
            System.out.println("[" + name + "]" + "阶段3完成");
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行");
    }
}
