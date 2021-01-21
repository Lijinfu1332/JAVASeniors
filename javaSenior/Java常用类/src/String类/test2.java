package String类;

public class test2 {
    //String的常用方法
    public static void main(String[] args) {
        String s1="Helloworld";
        System.out.println(s1.toUpperCase());//将字符串转换为daxie
        System.out.println(s1.toLowerCase());//将字符串转换为小写
        String s2="he   loo world  ";
        String s3=s2.trim();
        String s4=s3.concat(s1);
        System.out.println(s1.equalsIgnoreCase(s1.toLowerCase()));
        System.out.println(s4);
        System.out.println(s3);
        String s5="abc";
        String s6="abe";
        System.out.println(s5.contains(s6));
        System.out.println(s5.compareTo(s6));

    }
}
