package javatest2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-27 23:03
 */
public class OtherTest {

    /**
     * 获取运行时类的构造器
     */
    @Test
    public void testConstructor(){

        try {
            Class clazz = Class.forName("javatest1.Person");
            //获取当前运行时类声明为public的构造器
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c.getName());
            }
            System.out.println();
            //获取当前运行时类所有的构造器
            Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor c : declaredConstructors) {
                System.out.println(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取运行时类的父类
     */
    @Test
    public void testSuperclass(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Class superclass = clazz.getSuperclass();
            System.out.println(superclass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取运行时类带泛型的父类
     */
    @Test
    public void testGenSuperclass(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Type genericSuperclass = clazz.getGenericSuperclass();
            System.out.println(genericSuperclass.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取运行时类带泛型的父类的泛型
     */
    @Test
    public void testSuperclassGen(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Type genericSuperclass = clazz.getGenericSuperclass();
            ParameterizedType paraType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = paraType.getActualTypeArguments();
            if(actualTypeArguments != null || actualTypeArguments.length != 0){
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    if(actualTypeArguments.length - 1 == i){
                        System.out.println(actualTypeArguments[i].getTypeName());
                        break;
                    }
                    System.out.println(actualTypeArguments[i].getTypeName() + ",");

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取运行时类实现的接口
     */
    @Test
    public void testInterface(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Class[] interfaces = clazz.getInterfaces();
            for (Class c : interfaces) {
                System.out.println(c.getName());
            }
            System.out.println();
            //获取父类中的接口
            Class superclass = clazz.getSuperclass();
            Class[] interfaces1 = superclass.getInterfaces();
            for (Class c : interfaces1) {
                System.out.println(c.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取运行时类所在的包
     */
    @Test
    public void testPacket(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Package aPackage = clazz.getPackage();
            System.out.println(aPackage.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取运行时类声明的注解
     */
    @Test
    public void testAnno(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
