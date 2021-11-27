package danlimoshi;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-29 16:59
 */
public class LanHanShiTest1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "：" + LanHanShiT1.getLanHanShi());
    }

    public static void main(String[] args) {
        LanHanShiTest1 lanHanShiTest1 = new LanHanShiTest1();
        Thread t1 = new Thread(lanHanShiTest1);
        Thread t2 = new Thread(lanHanShiTest1);
        Thread t3 = new Thread(lanHanShiTest1);

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class LanHanShiT1 {
    private LanHanShiT1() {
    }

    private static LanHanShiT1 l1 = null;
//    解决办法一：
//    public static LanHanShiT1 getLanHanShi() {
//        if (l1 == null) {
//            synchronized (LanHanShiT1.class) {
//                if (l1 == null) {
//                    l1 = new LanHanShiT1();
//                }
//            }
//        }
//        return l1;
//    }
    //解决办法二：
    public static synchronized LanHanShiT1 getLanHanShi(){
        if(l1 == null){
            l1 = new LanHanShiT1();
        }
        return l1;
    }
}