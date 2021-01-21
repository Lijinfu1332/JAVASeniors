package String类;

import java.util.Date;

public class test5 {
    public static void main(String[] args) {
        StringBuffer buffer=new StringBuffer("1235");
        buffer.append("wedewew");
        System.out.println(buffer.insert(3,"wedededew"));
        System.out.println(buffer.delete(3,10));
        System.out.println(buffer.reverse());
        System.out.println(System.currentTimeMillis());
        Date date=new Date();
        System.out.println(date.toString());
        java.sql.Date date2=new java.sql.Date(date.getTime());
        System.out.println(date2.toString());
        Date date3=new java.sql.Date(date2.getTime());
        String s2="qqdqdqqdqw";
        System.out.println(s2.substring(2, 5));
        System.out.println(s2);
    }
}
