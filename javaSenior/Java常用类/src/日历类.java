import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class 日历类 {
    @Test
    public void testCleadar(){
        //创建日历对象
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getClass());
        //get方法
        //获取当前日期是这个月中的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //set方法
        //修改当前日期在本月中的天数
        calendar.set(Calendar.DAY_OF_MONTH,22);
        //add
        calendar.add(Calendar.DAY_OF_YEAR,5);
        //setTime
        Date date=new Date();
        calendar.setTime(date);
        System.out.println(date);
        //getTime
        Date date1=calendar.getTime();
    }
}
