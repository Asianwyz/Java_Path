package heima.Thread;

/*
    创建多线程程序的第二种方式：实现Runnable接口
    java.lang.Runnable
        Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为run的无参数方法。
    java.lang.Thread类的构造方法
        Thread(Runnable target) 分配新的构造方法
        Thread（Runnable target, String name) 分配新的Thread对象

    实现步骤：
        1. 创建一个Runnable接口的实现类
        2. 在实现类中重写Runnable接口的run方法，设置线程任务
        3. 创建一个Runnable接口的实现类对象
        4. 创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        5. 调用Thread类中的start方法，开启新的线程执行run方法

    实现Runnable接口创建多线程程序的好处:
        1. 避免了单线程的局限性
            一个类只能继承一个类（一个人只能有一个亲爹），类继承了Thread类就不能继承其他的类
            实现了Runnable接口，还可以继承其他的类，实现其他的接口
        2. 增强了程序的扩展性，降低了程序的耦合性（解耦）
            实现Runnable接口的方式，把设置线程任务和开启新线程进行了分离（解耦）
            实现类中，重写了run方法：用来设置线程任务
            创建Thread类对象，调用start方法：用来开启新线程

        1. 适合多个相同的程序代码的线程去共享同一个资源。
        2. 可以避免java中的单继承的局限性。
        3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
        4. 线程池只能放入实现Runnable或Callable类线程，不能直接放入继承Thread的类。
 */

public class _03Runnable {

    public static void main(String[] args) {
        RunnableImpl mt = new RunnableImpl();
        Thread t = new Thread(mt);
        t.start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }

}
