package 未分类.多线程;

import java.util.concurrent.Semaphore;

public class SequentialPrintingWithSemaphore {
    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);
    private static final int COUNT = 10;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> print("A", semaphoreA, semaphoreB));
        Thread threadB = new Thread(() -> print("B", semaphoreB, semaphoreC));
        Thread threadC = new Thread(() -> print("C", semaphoreC, semaphoreA));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void print(String content, Semaphore current, Semaphore next) {
        for (int i = 0; i < COUNT; i++) {
            try {
                current.acquire();
                System.out.println(content);
                next.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
