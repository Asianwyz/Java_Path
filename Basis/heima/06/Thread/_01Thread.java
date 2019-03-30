package heima.Thread;

/*
    创建多线程程序的第一种方式：创建Thread的子类
    java.lang.Thread类：是描述线程的类，我们想要实现多线程程序，就必须继承Thread类

    实现步骤：
        1. 创建一个Thread类的子类
        2. 在Thread类的子类中重写Thread类的run方法，设置线程任务（开启线程要做什么）
        3. 创建Thread类的子类对象
        4. 调用Thread类中的方法start方法，开启新的线程，执行run方法
            void start() 使该线程开始执行；Java虚拟机调用该线程的run方法
            结果是两个线程并发地运行；当前线程（main线程）和另一个线程（创建的新线程，执行其run方法）
 */

public class _01Thread {
    public static void main(String[] args) {
//        MyThread mt = new MyThread("新的线程");
//        // 开启新线程
//        mt.start();
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println("main线程！" + i );
//        }

        new ThreadGetName().start();
        new ThreadGetName().start();
        System.out.println(Thread.currentThread().getName());
        new ThreadSetName("Asia").start();
    }
}
