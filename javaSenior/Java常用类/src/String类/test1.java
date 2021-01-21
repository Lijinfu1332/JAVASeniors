package String类;

public class test1 {
    //String类型为不可变类型
    public static void main(String[] args) {
        String s1=new String("helloword");
        String s2="helloworld";
        System.out.println(s1 == s2);
        String s3="javaEEhdoop";
        String s4="javaEE";
        String s5="hdoop";
        String s6=s4+"hdoop";
        String s7="javaEE"+s5;
        String s8=s4+s5;
        System.out.println(s3 == s6);//true
        System.out.println(s3 == s8);//false
       String s9=s8.intern();
        System.out.println(s3 == s9);
    }
}
