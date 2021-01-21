import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 日期格式化 {
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //使用默认格式进行格式化
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date date=new Date();
        String format = sdf.format(date);
        System.out.println(format);
        Date parse = sdf.parse("2020/5/18 下午6:35");
        System.out.println(parse);
        //使用指定格式进行日期格式化
        SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        Date parse1 = sdf1.parse(format1);
        System.out.println(parse1);

    }
    //三天打鱼两天晒网练习
    public int fish(Date s1,Date s2){
        long time = s1.getTime();
        long time1 = s2.getTime();
        long cutTime=time-time1;
        int day= (int) (cutTime/(1000*60*60*24)+1);
        if (day%5==0){
            int fishing=day/5*3;
            int fished=day/5*2;
            System.out.println("打了"+fishing+"天的🐟,晒了"+fished+"天的网");
        }else {
            if (day%5>3){
                int fishing=day/5*3+3;
                int fished=day/5*2+day%5-3;
                System.out.println("打了"+fishing+"天的🐟,晒了"+fished+"天的网");
            }else {
                int fishing=day/5*3;
                int fished=day/5*2+day%5;
                System.out.println("打了"+fishing+"天的🐟,晒了"+fished+"天的网");
            }
        }
        return 0;
    }
    @Test
    public void testFish(){
        Date date2=new Date();
        //Scanner scanner=scanner=new Scanner(System.in);
        System.out.println("请输入你打鱼到那一天（格式为yyyy-MM-dd）：");
        String dat="2020-12-20";
        Date date1=null;
        try {
            //dat=scanner.nextLine();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            try {
                date1=sdf.parse(dat)  ;
                fish(date1,date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            System.out.println("您输入的字符串不符合要求");
        }
    }
}
