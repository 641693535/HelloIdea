package test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description util.date是sql.date的父类
 * @Effects
 * @create 2020-04-04 22:27
 */
public class TimeTest {
    @Test
    public void test3(){
        //util.Date --> sql.Date情况一：多态的形式
        java.sql.Date date3 = new java.sql.Date(5165465156L);
        Date date4 = date3;
        System.out.println("·············" + date4);
        java.sql.Date date5 = (java.sql.Date) date4;
        System.out.println(date5);

        //util.Date --> sql.Date;情况二：转化成时间戳，再转化成sql.Date类型
        Date date1 = new Date();
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }
    @Test
    public void systemTimeTest(){
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
    }
    @Test
    public void test1() throws ParseException {
        Date date = new Date();
        //指定格式化方式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化 日期-->字符串
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        //解析 字符串-->日期
        Date parse = simpleDateFormat.parse(format);
        System.out.println(parse);
        //解析二：
        Date parse1 = simpleDateFormat.parse("2020-11-21 5:05:00");
        System.out.println(parse1);
    }

    @Test
    public void test2(){
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
    }
}