package heima.Thread;

public class MyThread extends Thread{
    // 定义指定线程的构造方法

    public MyThread(String name) {
        super(name);    //  调用父类的String参数的构造方法，指定线程的名字
    }

    /*
        重写run方法，完成该线程执行的逻辑
     */
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":正在执行！" + i);
        }
    }
}
