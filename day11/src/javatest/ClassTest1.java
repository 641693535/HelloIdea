package javatest;

import org.junit.Test;

import java.util.Random;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-26 18:43
 */
public class ClassTest1 {

    /**
     * 创建一个随机返回正在运行时类的对象
     */
    @Test
    public void test1(){

        for (int i = 0; i <= 100; i++) {
            String classPath = "";
            int i1 = new Random().nextInt(3);
            switch (i1){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "javatest.Person";
                    break;
            }
            Object obj = null;
            try {
                obj = returnObj(classPath);
                System.out.println(obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public Object returnObj(String classPath) throws Exception {
        Class objectClass = Class.forName(classPath);
        return objectClass.getDeclaredConstructor().newInstance();
    }


}
