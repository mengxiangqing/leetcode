package threads;

public class ThreadTest {
    public static final int DELAY = 10;
    public static final int STEPS = 10;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        var bank = new Bank(4, 100000);

        Runnable task1 = () -> {
            try {
                int i = 0;
                while (!Thread.currentThread().isInterrupted() && i++ < STEPS) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int) (DELAY * Math.random()));

                }
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        };
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        };
        var thread1 = new Thread(task1);
        thread1.setName("线程1");
        thread1.start();

        Thread thread = new Thread(task2);
        thread.setName("线程2");
        thread.start();
        // thread1.interrupt();

    }
}
