package com.learn.algorithm.concurrent;

/**
 * 按序打印ABC
 *
 * @author yymuhua
 * @create 2020-03-23 21:07
 */
public class ABC {
    public static volatile int flag1;
    public static int flag2;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        printABC2();
    }

    /**
     * volatile int 作为标志
     */
    public static void printABC1() {
        flag1 = 0;
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                while (flag1 != finalI) { }
                System.out.println((char) ('A' + finalI));
                flag1 = flag1 < 2 ? flag1 + 1 : 0;
            }).start();
        }
    }

    /**
     * synchronized
     */
    public static void printABC2() {
        flag2 = 0;
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                synchronized (lock) {
                    while (flag2 != finalI) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println((char) ('A' + finalI));
                    flag2 = flag2 < 2 ? flag2 + 1 : 0;
                    lock.notifyAll();
                }
            }).start();
        }
    }
}
