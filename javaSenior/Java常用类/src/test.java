
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String string="2020-05-20";
        Date parse = sdf.parse(string);
        long time = parse.getTime();
        java.sql.Date date=new java.sql.Date(time);
        System.out.println(parse);

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date1 = (Date) dtf.parse(string);
        long time1 = date1.getTime();
        java.sql.Date date2=new java.sql.Date(time1);
        System.out.println(date);
    }
}
