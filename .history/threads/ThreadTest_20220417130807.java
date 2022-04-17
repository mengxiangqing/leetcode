package threads;

public class ThreadTest {
    public static final int DELAY = 100;
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
        var thread1 = new Thread(task1);
        thread1.setName("线程1");
        thread1.start();
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                    if (i == 5)
                        thread1.interrupt();
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        };
        Runnable task3 = () -> {
            try {
                while (true) {
                    Thread.sleep(1000l);// 阻塞状态，线程被调用了interrupte（）方法，清除中断标志，抛出InterruptedException
                    // dosomething
                    boolean isIn = Thread.currentThread().isInterrupted();
                    // 运行状态，线程被调用了interrupte（）方法，中断标志被设置为true
                    // 非阻塞状态中进行中断线程操作
                    if (isIn)
                        break;// 退出循环，中断进程
                }
            } catch (InterruptedException e) {// 阻塞状态中进行中断线程操作
                boolean isIn = Thread.interrupted();// 退出阻塞状态，且中断标志被清除，重新设置为false，所以此处的isIn为false
                return;// 退出run方法，中断进程
            }
        };

        Thread thread = new Thread(task2);
        thread.setName("线程2");
        thread.start();
        new Thread(task3).start();


    }
}
