package heima.Thread;

public class _07Demo {
    public static void main(String[] args) {

        Baozi bz = new Baozi();

        ChiHuo ch = new ChiHuo("吃货", bz);
        BaoziPu bzp = new BaoziPu("包子铺", bz);

        ch.start();
        bzp.start();
    }
}
