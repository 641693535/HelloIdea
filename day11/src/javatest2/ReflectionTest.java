package javatest2;

import javatest1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * 调用类中指定的结构：属性、方法、构造器
 *
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-28 15:09
 */
public class ReflectionTest {

    /**
     * 获取指定属性
     */
    @Test
    public void test1(){
        try {
            Class clazz = Class.forName("javatest1.Person");

            //获取属性所在的类
            Person p1 = (Person) clazz.getDeclaredConstructor().newInstance();
            //获取指定属性的方式一：
            //获取指定的属性
            Field id = clazz.getField("id");
            //调用指定属性并赋值
            id.set(p1, 1001);
            //获取指定属性
            System.out.println(id.get(p1));

            //获取指定属性的方式二(常用)：
            Field name = clazz.getDeclaredField("name");
            //允许访问权限
            name.setAccessible(true);
            //设置值
            name.set(p1, "Tom");
            System.out.println(name.get(p1));

            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定方法
     */
    @Test
    public void test2(){
        try {
            Class clazz = Class.forName("javatest1.Person");

            Person p1 = (Person) clazz.getDeclaredConstructor().newInstance();

            //获取指定的方法
            Method show = clazz.getDeclaredMethod("show", String.class);
            //允许访问权限
            show.setAccessible(true);
            //设置值
            String show1 = (String) show.invoke(p1, "CHN");

            System.out.println(show1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定构造器
     */
    @Test
    public void test3(){
        try {
            Class clazz = Class.forName("javatest1.Person");

            //获取指定的构造器
            Constructor constructor = clazz.getDeclaredConstructor(String.class);
            //允许访问权限
            constructor.setAccessible(true);
            //调用构造器并返回反射的对象
            Person p1 = (Person) constructor.newInstance("Jane");

            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
