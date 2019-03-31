package heima.Thread;

public class BaoziPu extends Thread{
    private Baozi bz;

    public BaoziPu(String name, Baozi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run(){
        int count = 0;
        while (true){
            synchronized (bz){
                if (bz.isFlag() == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 没有包子，造包子
                System.out.println("包子铺开始做包子");
                if (count % 2 == 0){
                    bz.setPier("冰皮");
                    bz.setXianer("五仁");
                }
                else{
                    bz.setPier("薄皮");
                    bz.setXianer("牛肉");
                }
                ++count;

                bz.setFlag(true);
                System.out.println("包子造好了：" + bz.getPier() + bz.getXianer());
                System.out.println("吃货来吃吧");
                // 唤醒等待线程
                bz.notify();
            }
        }
    }
}
