package Test;

/**
 * @author 64169 Email:641693535@qq.com
 * @Description Thread多线程测试的第一个程序
 * @Effects 查看主线程和thread线程的运行结果
 * @Version
 * @create 2020-03-26 17:44
 *
 * 多线程的创建方式一：
 * ① 创建一个继承于Thread类的子类；
 * ② 重写Thread类中的run()方法，run方法内为执行的代码；
 * ③ 创建Thread类的子类的实例对象
 * ④ 调用实例对象.start()方法，启动线程；
 */
class MyTestThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {
        MyTestThread t1 = new MyTestThread();
        t1.start();
        //已经start()的线程不能再进行start();
//        t1.start();
        //此时我们需要再创建一个对象，来启动这个线程；
        MyTestThread t2 = new MyTestThread();
        t2.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.print(Thread.currentThread().getName() + ":");
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
