package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-24 20:56
 */
public class ObjectInputOutputStreamTest {

    /**
     * 持久化一个对象流
     */
    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));

            oos.writeObject(new String("My-First-ObjectOutputStream----任"));
            oos.flush();

            oos.writeObject(new Person("任ZB",18));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    /**
     * 读取一个持久化的对象流
     */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
