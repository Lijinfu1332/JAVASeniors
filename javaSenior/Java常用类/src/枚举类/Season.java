package 枚举类;

 class Sasenr {
    private final String NAME;
    private final  String DCRB;
    public  Sasenr(String NAME,String DCRB){
       this.NAME=NAME;
        this.DCRB=DCRB;
    }
    public static final Sasenr SPRING=new Sasenr("春天","春暖花开");
    public static final Sasenr SUMMER=new Sasenr("夏天","夏天凉爽");
    public static final Sasenr AUTUMN=new Sasenr("秋天","秋高气爽");
    public static final Sasenr WINTER=new Sasenr("冬天","冰天雪地");

    public String getNAME() {
        return NAME;
    }

    public String getDCRB() {
        return DCRB;
    }

    @Override
    public String toString() {
        return "Sasenr{" +
                "NAME='" + NAME + '\'' +
                ", DCRB='" + DCRB + '\'' +
                '}';
    }
}
public class Season{
    public static void main(String[] args) {
        Sasenr sasenr=Sasenr.SPRING;
        System.out.println(sasenr);

    }
}
