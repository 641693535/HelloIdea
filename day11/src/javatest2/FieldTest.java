package javatest2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 * 获取当前运行时类的属性结构
 *
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-27 20:32
 */
public class FieldTest {

    //获取运行时类的属性
    @Test
    public void test1(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            //获取运行时类的public属性和所有父类的public属性
            Field[] fields = clazz.getFields();
            for (Field f : fields) {
                System.out.println(f);
            }
            System.out.println("************************");

            //获取运行时类的所有属性,包括Private和缺省
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields) {
                System.out.println(f);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取属性的信息：权限修饰符、类型、属性名
    @Test
    public void test2(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field f : declaredFields) {
                //获取权限修饰符
//                System.out.print(f.getModifiers());//返回0、1、2……表示权限
                System.out.print(Modifier.toString(f.getModifiers()) + "\t");//返回权限名字
                //获取类型
//                System.out.print(f.getType());//返回完整(带Class的)类型名
                System.out.print(f.getType().getName() + "\t");//返回只带包名的类型名
                //获取属性名
                System.out.println(f.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
