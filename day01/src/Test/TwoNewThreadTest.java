package Test;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description 两种创建Thread多线程方法的类
 * @Effects
 * @create 2020-03-28 15:03
 */
class OneThreadTest extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
class TwoThreadTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

public class TwoNewThreadTest{
    public static void main(String[] args) {
        OneThreadTest t1 = new OneThreadTest();
        TwoThreadTest two = new TwoThreadTest();
        Thread t2 = new Thread(two);

        t1.setName("多线程的创建方式一：");
        t2.setName("多线程的创建方式二：");

        t1.start();
        t2.start();
    }
}
