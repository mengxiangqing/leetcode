package threads;

public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("中断状态：" + Thread.interrupted());// 打印中断状态，并重置为false
                    System.out.println("线程被中断，程序退出。");

                } else {
                    System.out.println("中断状态已清除。");
                }

                try {
                    System.out.println(
                            "休眠三秒。");
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
