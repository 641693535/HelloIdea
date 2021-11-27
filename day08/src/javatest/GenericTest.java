package javatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-20 18:11
 */
public class GenericTest {


    @Test
    public void test1() {
//        //在集合中使用泛型之前
//        ArrayList list = new ArrayList();
//        list.add(123);
//        list.add("String");
//        list.add(new Date());

        //在集合中使用泛型之后
        ArrayList<Integer> list = new ArrayList<>();

        list.add(123);
        list.add(7899);
        list.add(123);


        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    //创建泛型方法：
    public <T> T Gen(T test){
        return test;
    }
}
//创建泛型接口
interface MyFirstInterface<T>{

}
