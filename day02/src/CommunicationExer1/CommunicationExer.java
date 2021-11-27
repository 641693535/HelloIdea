package CommunicationExer1;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-03-30 22:21
 */

class Number implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                //使上一个线程接触阻塞
                notify();
                if(num < 100){
                    System.out.println(Thread.currentThread().getName() + ":号码为:" + num);
                    num++;
                }else{
                    break;
                }
                //使线程执行完上述代码进入阻塞状态
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class CommunicationExer {

    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }

}
