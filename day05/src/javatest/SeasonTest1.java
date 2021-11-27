package javatest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-13 16:45
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //调用手动定义的枚举类
        Season summer = Season.SUMMER;
        System.out.println(summer);

        //调用enum类定义的枚举类
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
        System.out.println(Season1.class.getClass());

        //调用枚举类的方法
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            //调用接口中的show()方法
            values[i].show();
        }
        Season1 spring1 = Season1.valueOf("SPRING");
        System.out.println("找到了！" + spring);

        //调用枚举类的接口
        spring.show();
        Season1 summer1 = Season1.SUMMER;
        summer1.show();
    }
}

/**
 * 手动定义一个枚举类JDK5.0之前的方法：
 */
class Season{

    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "白雪皑皑");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
/**
 * 使用Enum类来定义枚举类JDK5.0之后新增特性
 */
enum Season1 implements Info{
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天在哪里？");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天在哪里？");
        }
    },
    WINTER("冬天", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天在哪里？");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
interface Info{
    void show();
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String value() default "hello";
}