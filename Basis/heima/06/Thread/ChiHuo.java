package heima.Thread;

public class ChiHuo extends Thread{
    private Baozi bz;

    public ChiHuo(String name, Baozi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run(){
        while(true){
            synchronized (bz){
                if (bz.isFlag() == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃" + bz.getPier() + bz.getXianer() + "包子");
                bz.setFlag(false);
                bz.notify();
            }
        }
    }
}
