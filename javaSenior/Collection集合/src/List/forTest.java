package List;

import org.junit.Test;

import java.util.*;

public class forTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Date());
        coll.add(new Person("lisi",15));
        for (Object obj:coll
             ) {
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(15);
        list.add(180);
        list.add(new Date());
        System.out.println(list);
        list.set(2,25);
        list.remove(1);
        System.out.println(list);
    }
    @Test
    public  void test3(){
        List list=new ArrayList();
        list.add(15);
        list.add(180);
        list.add(new Date());
        for (Object obj :
                list) {
            System.out.println(obj);
        }
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
