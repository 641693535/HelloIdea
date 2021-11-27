package javatest;

import java.io.Serializable;

/**
 * Person类实现可序列化
 *
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-24 21:09
 */
public class Person implements Serializable {

    private String name;
    private int age;

    private static final long serialVersionUID = 641696666L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
