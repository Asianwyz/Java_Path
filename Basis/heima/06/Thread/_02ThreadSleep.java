package heima.Thread;

/*
    public static void sleep(long time): 使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）
 */

public class _02ThreadSleep {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            // 使用Thread类的sleep方法让程序睡眠1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
