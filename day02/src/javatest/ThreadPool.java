package javatest;

import java.util.concurrent.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-01 20:27
 */
//class ThreadP implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if(i % 2 == 0){
//                System.out.println(i);
//            }
//        }
//    }
//}
class ThreadCallble implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10000);
//        service.execute(new ThreadP());
        Future submit = service.submit(new ThreadCallble());
        Object o = null;
        try {
            o = submit.get();
            System.out.println("运行的结果是：" + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        service.execute();//适用于Runnable;
//        service.submit();//适用于Callable;
        service.shutdown();
    }
}
