import java.util.concurrent.CountDownLatch;

/**
 * @author yymuhua
 * @create 2020-04-14 16:21
 */
public class Main {
    public static int num;
    public static final int THREAD_NUMBER = 10;
    public static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUMBER);
    public static void main(String[] args) throws Exception {
        System.out.println("----------init num = " + num);
        for(int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                synchronized(Main.class) {
                    for(int j = 0; j < 10; j++) {
                        System.out.println(name + " -> " + (++num));
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("----------final num = " + num);
    }
}
class A {
    public void method(){

    }
}
class B extends A {
    public void method() {

    }
}