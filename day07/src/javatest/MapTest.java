package javatest;

import org.junit.Test;

import java.util.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-19 15:16
 */
public class MapTest {

    @Test
    public void test1(){
        HashMap map = new HashMap();
        map.put("First", 123);
        map.put("Second", 13);
        map.put("Last", 123);

        //修改
        map.put("First", 345);
        System.out.println(map);

        //遍历
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }

        System.out.println("*********");

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        Set set2 = map.keySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "====" + value);

        }

    }

}
