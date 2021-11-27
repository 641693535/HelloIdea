package javatest2;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-29 17:52
 */
public class LambdaTest {

    @Test
    public void test1(){

        Comparator<String> str1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(str1.compare("a", "b"));

        System.out.println("**********************");

        Comparator<String> str2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(str2.compare("c", "a"));
    }

}
