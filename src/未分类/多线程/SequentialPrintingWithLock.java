package 未分类.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SequentialPrintingWithLock {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static int state = 1;
    private static final int COUNT = 10;

    public static void main(String[] args) {
//        Thread threadA = new Thread(() -> print("A", 1, 2, conditionA, conditionB));
//        Thread threadB = new Thread(() -> print("B", 2, 3, conditionB, conditionC));
//        Thread threadC = new Thread(() -> print("C", 3, 1, conditionC, conditionA));
        new Thread(new Print("A", 1, 2, conditionA, conditionB)).start();
        new Thread(new Print("B", 2, 3, conditionB, conditionC)).start();
        new Thread(new Print("C", 3, 1, conditionC, conditionA)).start();

//        threadA.start();
//        threadB.start();
//        threadC.start();
    }

    private static void print(String content, int currentState, int nextState, Condition currentCondition, Condition nextCondition) {
        for (int i = 0; i < COUNT; i++) {
            lock.lock();
            try {
                while (state != currentState) {
                    currentCondition.await();
                }
                System.out.println(content);
                state = nextState;
                nextCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Print implements Runnable {
        private final String content;
        private final int currentState;
        private final int nextState;
        private final Condition currentCondition;
        private final Condition nextCondition;

        public Print(String content, int currentState, int nextState, Condition currentCondition, Condition nextCondition) {
            this.content = content;
            this.currentState = currentState;
            this.nextState = nextState;
            this.currentCondition = currentCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                lock.lock();
                try {
                    while (state != currentState) {
                        currentCondition.await();
                    }
                    System.out.println(content);
                    state = nextState;
                    nextCondition.signal();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
