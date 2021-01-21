package 枚举类;

import javax.swing.plaf.nimbus.State;

public class enumSeason {
    public static void main(String[] args) {
    Season1 summer=Season1.SUMMER;
        System.out.println(summer);
        //获取常量名
        Season1[] season1=Season1.values();
        for (int i = 0; i < season1.length; i++) {
            System.out.println(season1[i]);
            season1[i].show();
        }
        //enum自带的
        //获取类中的ObjectName
        //类名找不到时会抛出异常
        Season1 season11=Season1.valueOf("SPRING1");
        System.out.println(season11);
    }
}
 interface Info{
    void show();
}
 enum  Season1 implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
     SUMMER("夏天","夏日凉凉"){
         @Override
         public void show() {
             System.out.println("夏天夏天悄悄地过去");
         }
     },
     AUTOMN("秋天","秋高气爽"){
         @Override
         public void show() {
             System.out.println("秋天不回来");
         }
     },
     WINTER("冬天","冰天雪地"){
         @Override
         public void show() {
             System.out.println("大约在冬季");
         }
     }
     ;
    private String name;
    private String DCRB;

    Season1(String name, String DCRB){
        this.name=name;
        this.DCRB=DCRB;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDCRB() {
        return DCRB;
    }

    public void setDCRB(String DCRB) {
        this.DCRB = DCRB;
    }
}
