package String类;

import java.io.UnsupportedEncodingException;

public class test4 {
    public static void main(String[] args) {
        //String 与 int之间的转换
        String s1="123";
        int a=Integer.parseInt(s1);
        System.out.println(a);
        //String 与char[]间的转换
        char[] s2=s1.toCharArray();
        for (int i = 0; i < s2.length ;i++) {
            System.out.println(s2[i]);

        }

        char[] s3=new char[]{'1','2','3'};
        String s4=new String(s3);
        System.out.println(s4);
        //String 与 byte间的转换
        String string="abc123 中国";
        byte[] bt= new byte[0];
        try {
            bt = string.getBytes("gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bt.length; i++) {
            System.out.println(bt[i]);
        }
        System.out.println(bt);
        String st= null;
        try {
            st = new String(bt,"gbk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(st);
    }
}
