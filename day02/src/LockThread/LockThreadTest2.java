package LockThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-29 12:34
 */
// 使用synchronized同步锁的方式：
//class WindowRun1 extends Thread{
//    private static int ticket = 100;
//    private static Object obj = new Object();
//    public void run(){
//
//        while (true) {
////            synchronized (WindowRun1.class) {
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
//class WindowRun1 extends Thread {
//    private static int ticket = 100;
//
//    public void run() {
//        while (ticket > 0) {
//            show();
//        }
//    }
//
//    private static synchronized void show() {
//        if (ticket > 0) {
//            System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
//            ticket--;
//        }
//    }
//}
class WindowRun1 extends Thread {
    private static int ticket = 100;
    private static ReentrantLock lock = new ReentrantLock();

    public void run() {
        while(true){
                    try{
                        //手动开启同步锁
                        lock.lock();
                        Thread.sleep(100);
                        if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ":票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //手动关闭同步锁
                lock.unlock();
            }
        }
    }
}

public class LockThreadTest2 {
    public static void main(String[] args) {
        WindowRun1 t1 = new WindowRun1();
        WindowRun1 t2 = new WindowRun1();
        WindowRun1 t3 = new WindowRun1();

        t1.setName("线程一");
        t2.setName("线程二");
        t3.setName("线程三");

        t1.start();
        t2.start();
        t3.start();

    }
}
