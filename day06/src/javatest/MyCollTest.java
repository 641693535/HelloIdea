package javatest;

import java.util.Objects;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-16 13:53
 */
public class MyCollTest {
    private String name;
    private int age;

    public MyCollTest() {
    }

    public MyCollTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCollTest that = (MyCollTest) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }
}
