package com.learn.algorithm.concurrent;

/**
 * 按序打印ABC
 *
 * @author yymuhua
 * @create 2020-03-23 21:07
 */
public class ABC {
    public static volatile int flag;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
//                while(true) {
//                    synchronized(ABC.class) {
                while (flag != finalI) {
//                            try {
//                                ABC.class.wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                }
                System.out.println((char) ('A' + finalI));
                if (finalI != 2) flag++;
                else flag = 0;
//                        ABC.class.notifyAll();
//                    }
//                }
            }).start();
        }
    }
}
