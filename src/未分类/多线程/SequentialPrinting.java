package 未分类.多线程;

public class SequentialPrinting {
    private static final Object lock = new Object();
    private static int state = 1;
    private static final int COUNT = 10;

    public static void main(String[] args) {
        Thread threadA = new Thread(new Printer("A", 1, 2));
        Thread threadB = new Thread(new Printer("B", 2, 3));
        Thread threadC = new Thread(new Printer("C", 3, 1));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class Printer implements Runnable {
        private final String content;
        private final int currentState;
        private final int nextState;

        public Printer(String content, int currentState, int nextState) {
            this.content = content;
            this.currentState = currentState;
            this.nextState = nextState;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    while (state != currentState) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(content);
                    state = nextState;
                    lock.notifyAll();
                }
            }
        }
    }
}
