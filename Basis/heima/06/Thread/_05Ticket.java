package heima.Thread;

/*
    模拟卖票案例
    创建3个线程,同时开启,对共享的票进行出售
    发现会重复卖票
 */

public class _05Ticket {

    public static void main(String[] args) {
//        RunnableImplSafe t1 = new RunnableImplSafe();
//        RunnableImplSafe t2 = new RunnableImplSafe();
//        RunnableImplSafe t3 = new RunnableImplSafe();

//        RunnableImplSynchronized t1 = new RunnableImplSynchronized();

//        RunableImplSynchronizedFunction t1 = new RunableImplSynchronizedFunction();
        RunnableLock t1 = new RunnableLock();

        Thread r1 = new Thread(t1);
        Thread r2 = new Thread(t1);
        Thread r3 = new Thread(t1);

        r1.start();
        r2.start();
        r3.start();
    }

}
