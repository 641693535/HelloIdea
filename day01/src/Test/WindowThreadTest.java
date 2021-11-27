package Test;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-27 20:33
 */
//继承于Thread的方式
//class WindowThread extends Thread{
//
//    private static int ticket = 100;
//    public void run(){
//        while(true){
//            if (ticket > 0) {
//                System.out.println(getName() + ":票号为：" + ticket--);
//            }else {
//                break;
//            }
//        }
//    }
//}
class WindowThread implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket--);
            }else{
                break;
            }
        }
    }
}

public class WindowThreadTest {
    public static void main(String[] args) {
        //继承于Thread的方式
//        WindowThread t1 = new WindowThread();
//        WindowThread t2 = new WindowThread();
//        WindowThread t3 = new WindowThread();

        WindowThread win1 = new WindowThread();

        Thread t1 = new Thread(win1);
        Thread t2 = new Thread(win1);
        Thread t3 = new Thread(win1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
