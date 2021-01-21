import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class localDate {
    @Test
    public void testLocal(){
        //JDK1.8的的时间使用
        //获取当前日期
        LocalDate localDate=LocalDate.now();
        //获取当前的时间
        LocalTime localTime=LocalTime.now();
        //获取当前时间+日期
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //创建时间
        LocalDateTime localDateTime1=localDateTime.of(2000,9,25,13,25,15);
        System.out.println(localDateTime1);
        //getXXX
        //获取今天是当月中的第几天
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfYear());
        //在当前时间加上五分钟
        System.out.println(localDateTime1.plusMinutes(5));
        //在当前时间减去三小时
        System.out.println(localDateTime.minusHours(3));
    }
}
