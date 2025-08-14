package 未分类;

public class 多线程打印100 {
    public class OrderedPrinting {
        private static int currentNum = 1;
        private static final Object lock = new Object();

        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) { // 10个线程
                new Thread(new Printer(i)).start();
            }
        }

        static class Printer implements Runnable {
            private final int threadId;

            public Printer(int threadId) {
                this.threadId = threadId;
            }

            @Override
            public void run() {
                while (currentNum <= 100) {
                    synchronized (lock) {
                        // 每个线程只打印自己轮次的数字（线程0打印1,11,21...，线程1打印2,12,22...）
                        while (currentNum % 10 != threadId && currentNum <= 100) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        if (currentNum <= 100) {
                            System.out.println("Thread-" + threadId + ": " + currentNum);
                            currentNum++;
                        }
                        lock.notifyAll(); // 唤醒其他线程
                    }
                }
            }
        }
    }
}
