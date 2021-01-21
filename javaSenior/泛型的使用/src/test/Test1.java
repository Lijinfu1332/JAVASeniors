package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    @Test
    public void test1(){
        //泛型的使用：保证数据的安全
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(11);
        list.add(12);
        list.add(15);
        list.add(18);
        list.add(1);
        //数据的遍历：
        //方式一：foreach循环
        for (Integer code:list) {
                Integer scode=code;
            System.out.println(scode);
        }
        //方式二：迭代器
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            Integer code=iterator.next();
            System.out.println(code);
        }
    }
}
