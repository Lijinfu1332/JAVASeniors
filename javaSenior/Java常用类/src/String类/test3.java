package String类;

public class test3 {
    public static void main(String[] args) {
        String s1 ="this is a test";
        System.out.println(s1.startsWith("this"));//字符串的开始
        System.out.println(s1.endsWith("tes"));//字符串以什么结尾
        String s2=s1.replace("this","test");
        System.out.println(s2);
        s1.matches(" ");
        String s4=s1.replaceAll(" ","");
        System.out.println(s4);
    }
}
