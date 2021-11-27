package javatest;

import org.junit.Test;

import java.util.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-16 13:50
 */
public class CollectionTest1 {
    @Test
    public void test1(){
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add("AAA");
        coll.add(new MyCollTest());

        //isEmpty()是否是空集合
        System.out.println(coll.isEmpty());

        //contains(Object obj)是否包含某个元素
        System.out.println(coll.contains(new MyCollTest()));

        //containsAll(Collection c)是否包含c中的所有元素
        List<Integer> integers = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(integers));

        //remove(Object obj)删除obj元素
        System.out.println(coll.remove(new MyCollTest()));

        //删除差集
        System.out.println(coll.removeAll(integers));

        //删除交集
//        System.out.println(coll.retainAll(integers));

        //判断两个集合内容是否相等
        System.out.println(coll.equals(integers));

        //获取集合对象的hash值
        System.out.println(coll.hashCode());

        //遍历
        System.out.println();
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add("AAA");
        coll.add(new MyCollTest());

        System.out.println(coll.size());

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            if ("AAA".equals(iterator.next())) {
                iterator.remove();
            }
        }

        System.out.println(coll.size());
    }

    @Test
    public void testFor(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add("AAA");
        coll.add(new MyCollTest());

        for(Object obj : coll){
            System.out.println(obj);
        }
    }
}
