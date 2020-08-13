package com.learn.algorithm.concurrent;

/**
 * 生产者、消费者问题
 * @author yymuhua
 * @create 2020-03-25 14:01
 */
public class ConsumerAndProducer {
    public static final Object lock = new Object();
    public static volatile boolean productable = true;

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                synchronized (lock) {
                    while(!productable) {
                        try {lock.wait();}catch (Exception e){}
                    }
                    System.out.println(finalI + "生产了产品 ");
                    productable = false;
                    lock.notifyAll();
                }
            }).start();

            new Thread(() -> {
                synchronized (lock) {
                    while(productable) {
                        try {lock.wait();}catch (Exception e){}
                    }
                    System.out.println(finalI + "消费了产品 ");
                    productable = true;
                    lock.notifyAll();
                }
            }).start();

        }
    }
}
