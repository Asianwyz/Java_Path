package heima.Thread;

// 创建一个Runnable接口的实现类
public class RunnableImpl implements Runnable{
    @Override
    public void run(){  // 设置线程任务
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
