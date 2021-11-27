package test;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-10 19:11
 */
public class DayTimeTest1 {
    @Test
    public void test1(){
        Calendar calendar = Calendar.getInstance();
        //get
        int i = calendar.get(Calendar.DAY_OF_YEAR);// 今天是这一年中的第几天
        System.out.println(i);
        //set
        calendar.set(Calendar.DAY_OF_MONTH,15);
        int i1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i1);
        //add
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        int i2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i2);
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime

        //setTime
    }
}
