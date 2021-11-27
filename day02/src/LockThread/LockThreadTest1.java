package LockThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-29 12:28
 */
// 使用synchronized同步锁的方式：
//class WindowRun implements Runnable{
//    private int ticket = 100;
//    private Object obj = new Object();
//    @Override
//    public void run() {
//        while (true){
////            synchronized (this) {
//            synchronized (obj){
//                if (ticket > 0) {
//                    System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
//                    ticket--;
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//}
// 使用synchronized同步方法的方式：
//class WindowRun implements Runnable{
//    private int ticket = 100;
//    @Override
//    public void run() {
//        while (ticket > 0){
//            show();
//        }
//    }
//    private synchronized void show(){
//        if(ticket > 0){
//            System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
//            ticket--;
//        }
//    }
//}

//使用ReentrantLock方式：
class WindowRun implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                //手动的开启锁
                lock.lock();

                Thread.sleep(100);

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
                //手动的关闭锁
                lock.unlock();
            }
        }
    }

}

public class LockThreadTest1 {
    public static void main(String[] args) {
        WindowRun windowRun = new WindowRun();
        Thread t1 = new Thread(windowRun);
        Thread t2 = new Thread(windowRun);
        Thread t3 = new Thread(windowRun);

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();
    }
}
