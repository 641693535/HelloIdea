package javatest2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * 获取当前运行时类的方法结构
 *
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-27 21:42
 */
public class MethodTest {

    @Test
    public void test1(){
        try {
            Class clazz = Class.forName("javatest1.Person");
            //获取运行时类的public方法和所有父类的public方法
            Method[] methods = clazz.getMethods();
            for(Method m : methods){
                System.out.println(m);
            }
            System.out.println("****************");
            //获取运行时类的所有属性,包括Private和缺省
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for(Method m : declaredMethods){
                System.out.println(m);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    @注解
    权限修饰符 返回值类型 方法名(形参类型1 形参名2,形参类型2 形参名2) throws 异常名{}
     */
    @Test
    public void test2(){

        try {
            Class clazz = Class.forName("javatest1.Person");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for(Method m : declaredMethods) {
                //获取运行时的@注解
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    System.out.println(a);
                }

                //获取运行时类的权限修饰符
                System.out.print(Modifier.toString(m.getModifiers()) + "\t");

                //获取返回值类型
                System.out.print(m.getReturnType().getName() + "\t");

                //获取方法名
                System.out.print(m.getName() + "(");

                //获取形参列表
                Class[] parameterTypes = m.getParameterTypes();
                if(!(parameterTypes == null || parameterTypes.length == 0)){
                    for(int i = 0;i < parameterTypes.length;i++){
                        if(i == parameterTypes.length - 1){
                            System.out.print(parameterTypes[i].getName() + " args_" + i);
                            break;
                        }
                        System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                    }
                }

                System.out.print(")\t");

                //获取抛出的异常
                Class[] exceptionTypes = m.getExceptionTypes();
                if(!(exceptionTypes == null || exceptionTypes.length == 0)){
                    System.out.print(" throws ");
                    for (int i = 0; i < exceptionTypes.length; i++) {
                        if(i == exceptionTypes.length - 1) {
                            System.out.print(exceptionTypes[i].getName());
                            break;
                        }

                        System.out.print(exceptionTypes[i].getName() + ",");
                    }
                }

                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
