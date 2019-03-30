package heima.Thread;

/*
    等待唤醒案例:线程之间的通信
        创建一个顾客线程(消费者):告知老板要的包子的种类和数量,调用wait方法,放弃cpu的执行,进入到WAITING状态(无限等待)
        创建一个老板线程(生产者):花了5秒做包子,做好包子之后,调用notify方法,唤醒顾客吃包子

    注意:
        顾客和老板线程必须使用同步代码块包裹起来,保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须保证唯一
        只有锁对象才能调用wait和notify方法

    Obejct类中的方法
    void wait()
          在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
    void notify()
          唤醒在此对象监视器上等待的单个线程。
          会继续执行wait方法之后的代码
 */

public class _06WaitAndNotify {
    public static void main(String[] args) {
        Object obj = new Object();
        // 创建一个顾客线程
        new Thread(){
            @Override
            public void run(){
                while (true){
                    synchronized (obj){
                        System.out.println("顾客1告知老板要的包子种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //  唤醒
                        System.out.println("包子已经做好了，顾客1开吃！");
                    }
                }
            }
        }.start();
        // 创建一个顾客线程
        new Thread(){
            @Override
            public void run(){
                while (true){
                    synchronized (obj){
                        System.out.println("顾客2告知老板要的包子种类和数量");
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //  唤醒
                        System.out.println("包子已经做好了，顾客2开吃！");
                    }
                }
            }
        }.start();

        // 创建一个老板线程
        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        System.out.println("老板5秒后做好包子，告知顾客，可以吃包子了");
                        obj.notifyAll();
                    }
                }
            }
        }.start();
    }
}
