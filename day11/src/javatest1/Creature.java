package javatest1;

import java.io.Serializable;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-27 20:19
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物进食");
    }

}
