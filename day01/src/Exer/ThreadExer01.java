package Exer;

/**
 * @author 64169 Email:641693535@qq.com
 * @Description 多线程基础小练习
 * @Effects 创建两个分线程，一个遍历100内的偶数，一个遍历奇数
 *          解决办法:写两个继承于Thread类的子类.
 * @Version
 * @create 2020-03-26 18:50
 */
class ThreadExer1 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
class ThreadExer2 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
public class ThreadExer01 {
    public static void main(String[] args) {
        ThreadExer1 t1 = new ThreadExer1();
        ThreadExer2 t2 = new ThreadExer2();
        t1.start();
        t2.start();
    }
}
