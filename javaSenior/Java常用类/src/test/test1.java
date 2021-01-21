package test;

public class test1 {
    @myAnnoction
    public static void main(String[] args) {
        Stool stool=new Stool(3.0,1,1.5,5,4.0,1);
        System.out.println(stool.toString());
        System.out.println("Area is "+stool.getArea());
        System.out.println("Vol is "+stool.getVol());
    }
}
