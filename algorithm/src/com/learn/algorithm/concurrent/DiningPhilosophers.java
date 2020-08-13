package com.learn.algorithm.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 哲学家进餐
 *
 * @author yymuhua
 * @create 2020-04-14 21:27
 */
public class DiningPhilosophers {
    public static final Object[] locks = new Object[]{new Object(),
            new Object(),
            new Object(),
            new Object(),
            new Object(),};
    public static Semaphore sema = new Semaphore(4);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    int leftFork = finalI;
                    int rightFork = (finalI + 1) % 5;
                    try {
                        sema.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (locks[leftFork]) {
                        synchronized (locks[rightFork]) {
                            System.out.println(finalI + "号哲学家进餐...");
                        }
                    }
                    sema.release();

                }
            }).start();
        }
    }
}
