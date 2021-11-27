package javatest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK5.0新增--Callable实现多线程的方式三
 * 1. 创建一个实现callable接口的类
 * 2. 实现callable的call方法
 * 3. 创建实现Callable类的实例
 * 4. 创建FutureTask实例，讲Callable实例作为形参传递给FutureTask构造器
 * 5. 创建Thread实例，将FutureTask实例作为形参传递给Thread构造器并start运行
 * 6. 调用FutureTask实例的get方法，得到Object类型的参数。
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-01 14:15
 */
class NumberTest1 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}

public class CallableTest1 {
    public static void main(String[] args) {
        NumberTest1 numberTest1 = new NumberTest1();

        FutureTask futureTask = new FutureTask(numberTest1);

        new Thread(futureTask).start();

        try {
            Object o = futureTask.get();
            System.out.println("总和为：" + o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
