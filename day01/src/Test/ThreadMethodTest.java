package Test;

/**
 * @author 64169 Email:641693535@qq.com
 * @Description 测试Thread类中的常用方法
 * @Effects
 * 1.currentThread()~获取当前线程
 * 2.start()~开始线程
 * 3.run()~线程的执行代码
 * 4.getName()~获取当前线程名字
 * 5.setName()~设置当前线程名字
 * 6.yield()~释放当前CPU执行权
 * 7.join()~在线程a中调用线程b的join()方法,此时的线程a进入阻塞状态，
 *        直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop()~已过时，当执行此方法时，强制结束此线程
 * 9.sleep(long millitime)~让当前线程“睡眠”指定millitime毫秒，“睡眠”时，为阻塞状态
 * 10.isAlive()~检测线程是否还存活，存活返回true；
 * @Version
 * @create 2020-03-26 20:14
 */
class HelloThread extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + getPriority() + ":" + i);

//            if(i % 2 == 0){
//                Thread.currentThread().yield();

//            if(i % 2 == 0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }
        }
    }
    public HelloThread(String name){
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
//        HelloThread t1 = new HelloThread();
        HelloThread t1 = new HelloThread("线程：1");
//        t1.setName("线程一");
        //设置线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();

        Thread.currentThread().setName("主线程");
        System.out.println(t1.isAlive());
        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);

//            if(i == 20){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    System.out.println(e.getMessage());
//                }
//            }

        }
    }




}
