package threads;

public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                System.out.println("线程状态："+ Thread.interrupted());//打印中断状态，并重置为false
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被中断，程序退出。");
                    return;
                } else {
                    System.out.println("线程状态已清除。");
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("线程休眠被中断，程序退出。");
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
