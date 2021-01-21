package Map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {
    @Test
    public  void test1(){
        List list=new ArrayList();
        for (int i=1;i<=10;i++){
            System.out.println("请输入第"+i+"个整数：");
            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();
            list.add(num);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        List list=new ArrayList();
        for (int i=1;i<=10;i++){
            System.out.println("请输入第"+i+"个整数：");
            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();
            list.add(num);
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
