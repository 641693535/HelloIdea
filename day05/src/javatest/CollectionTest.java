package javatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-14 22:04
 */
public class CollectionTest {
    @Test
    public void testCollection(){
        ArrayList list = new ArrayList();

        //1.add(Object e)方法：添加e到集合中
        list.add("AA");
        list.add("BB");
        list.add(123);
        list.add(new Date());

        //2.size()：返回集合的长度
        System.out.println(list.size());

        //3.toString()：打印集合中的元素内容
        System.out.println(list);

        //4.addAll(Collection coll)：讲coll中的所有元素添加进来
        ArrayList coll = new ArrayList();
        coll.add("CC");
        coll.add(456);

        list.addAll(coll);

        System.out.println(list.size());

        System.out.println(list);

        //5.clear()：删除集合中的所有元素
        list.clear();

        System.out.println(list.size());

    }
}
