package test;

import org.junit.Test;

import java.time.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-12 14:26
 */
public class JDK8DateTimeTest {
    /*
    LocalDate\LocalTime\LocalDateTime
     */
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()
        LocalDateTime ofdateTime = LocalDateTime.of(2020, 5, 1, 15, 00, 1);
        System.out.println(ofdateTime);

        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());

        //withXxx()
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(8);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //plusXxx()
        LocalDateTime localDateTime2 = localDateTime.plusWeeks(1);
        LocalDateTime localDateTime3 = localDateTime.plusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);

        //minusXxx()
        LocalDateTime localDateTime4 = localDateTime.minusDays(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }
    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);

        Instant instant1 = Instant.ofEpochMilli(1586678159999L);
        System.out.println(instant1);
    }
}
